/*
 * Copyright (c) 2014-2019, Draque Thompson, draquemail@gmail.com
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 *  See LICENSE.TXT included with this code to read the full license agreement.

 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.darisadesigns.polyglotlina.Nodes;

import org.darisadesigns.polyglotlina.PGTUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * class to contain declension transformation rule and all transformations
 * associated with the rule
 * @author draque
 */
public class DeclensionGenRule implements Comparable<DeclensionGenRule> {
    private int typeId;
    private int index;
    private String combinationId;
    private String regex = "";
    private String name = "";
    private List<DeclensionGenTransform> transformations = new ArrayList<>();
    private final Map<Integer, Integer> applyToClasses = new HashMap<>();
    private DeclensionGenTransform transBuffer = new DeclensionGenTransform();
    
    /**
     * Gets current declension transform buffer
     * @return current transform buffer
     */
    public DeclensionGenTransform getTransBuffer() {
        return transBuffer;
    }
    
    /**
     * Inserts current transform buffer, then sets to blank
     */
    public void insertTransBuffer() {
        addTransform(transBuffer);
        transBuffer = new DeclensionGenTransform();
    }
    
    /**
     * Sets declension gen rule equal to passed value, copying all subnodes
     * @param r rule to copy from
     * @param setTypeAndComb set to true to copy the typeId and combinationId
     * from the original, false to skip values
     */
    public void setEqual(DeclensionGenRule r, boolean setTypeAndComb) {
        if (setTypeAndComb) {
            typeId = r.getTypeId();
            combinationId = r.getCombinationId();
        }
        name = r.getName();
        regex = r.getRegex();
        transformations.clear();
        r.getTransforms().stream().map((copyFrom) -> {
            DeclensionGenTransform copyTo = new DeclensionGenTransform();
            copyTo.setEqual(copyFrom);
            return copyTo;
        }).forEachOrdered((copyTo) -> {
            transformations.add(copyTo);
        });
        
        for (Entry<Integer, Integer> classEntry : r.getClassFilterList().entrySet()) {
            this.addClassToFilterList(classEntry.getKey(), classEntry.getValue());
        }
    }
    
    /***
     * Checks if Gen Rules are equal. The combination ID is NOT accounted for, 
     * as this is used when checking equality across rules set to different
     * declensions. ID is also not accounted for, as this is an identity value.
     * It also does not apply to the applyToClasses values, as this is similar
     * to the first requirement.
     * @param o
     * @return 
     */
    public boolean valuesEqual(Object o) {
        boolean ret = true;
        
        if (this != o) {
            if (o != null && o instanceof DeclensionGenRule) {
                DeclensionGenRule comp = (DeclensionGenRule)o;
                ret = this.typeId == comp.typeId
                        && this.regex.equals(comp.regex)
                        && this.name.equals(comp.name)
                        && this.transformations.equals(comp.transformations);
            } else {
                ret = false;
            }
        }
        
        return ret;
    }
    
    /**
     * initializes new declension rule
     * @param _typeId TypeID of type this rule applies to
     * @param _combinationId the combined ID of the constructed declension rule applies to
     */
    public DeclensionGenRule(int _typeId, String _combinationId) {
        typeId = _typeId;
        combinationId = _combinationId;
    }
    
    public DeclensionGenRule() {
        typeId = -1;
        combinationId = "";
    }
    
    /**
     * adds transformation to rule
     * @param trans transformation to add
     */
    public void addTransform(DeclensionGenTransform trans) {
        transformations.add(trans);
    }
    
    /**
     * gets all transformations for this rule
     * @return iterator of DeclensionGenTransform objects
     */
    public List<DeclensionGenTransform> getTransforms() {
        return transformations;
    }
    
    /**
     * wipes all transformations
     */
    public void wipeTransforms() {
        transformations = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
    
    public int getTypeId() {
        return typeId;
    }
    
    public void setTypeId(int _typeId) {
        typeId = _typeId;
    }
    
    public String getCombinationId() {
        return combinationId;
    }
    
    public void setCombinationId(String _combinationId) {
        combinationId = _combinationId;
    }
        
    public String getRegex() {
        return regex;
    }
    
    public void setRegex(String _regex) {
        regex = _regex;
    }
    
    @Override
    public String toString() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    /**
     * Tests whether a word should have this rule applied to it. First tests based on the part of speech (type)
     * Second tests on class of word. -1 in applyToClasses means "apply to all"
     * @param word word to test rule for
     * @return true if rule should be applied to word
     */
    public boolean doesRuleApplyToWord(ConWord word) {
        boolean ret = false;
        boolean wordTypeHasClasses = 
                !word.getCore().getWordPropertiesCollection().getClassesForType(word.getWordTypeId()).isEmpty();
        
        // if -1 opresent in this rule, apply to all. Otherwise test against word classes. Skips mismatching PoS
        if (typeId == word.getWordTypeId() && (!wordTypeHasClasses || applyToClasses.containsKey(-1))) {
            ret = true;
        } else if (typeId == word.getWordTypeId()) {
            ret = true;
            
            // if a word does not match all of the entries in the required classes, reject
            for (Entry<Integer, Integer> curEntry : applyToClasses.entrySet()) {
                int classId = curEntry.getKey();
                
                if (!word.wordHasClassValue(classId, curEntry.getValue())) {
                    ret = false;
                    break;
                }
            }
        }
        
        return ret;
    }
    
    /**
     * organizes by index number
     * @param _compare node to compare
     * @return 
     */
    @Override
    public int compareTo(DeclensionGenRule _compare) {
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        int compIndex = _compare.getIndex();
        int ret;
        
        
        if (index > compIndex) {
            ret = AFTER;
        } else if (index == compIndex) {
            ret = EQUAL;
        } else {
            ret = BEFORE;
        }
        
        return ret;
    }
    
    /**
     * Returns true if this rule applies to a word of a given class. -1 indicates a test for cases of no class
     * @param classId word class to test
     * @param valueId value of word class to test
     * @return true if the rule should apply to this class value
     */
    public boolean doesRuleApplyToClassValue(Integer classId, Integer valueId) {
        return this.doesRuleApplyToClassValue(classId, valueId, false);
    }
    
    /**
     * Returns true if this rule applies to a word of a given class. -1 indicates a test for cases of no class
     * @param classId word class to test
     * @param valueId value of word class to test
     * @param overrideDefault set to true if ignoring "All" value (-1)
     * @return true if the rule should apply to this class value
     */
    public boolean doesRuleApplyToClassValue(Integer classId, Integer valueId, boolean overrideDefault) {
        boolean ret = false;
        
        // if test for universal inclusion (-1 == include all classes and values)
        if (classId != -1 && applyToClasses.containsKey(-1) && ! overrideDefault) {
            ret = true;
        } else if (applyToClasses.containsKey(classId)) {
            ret = applyToClasses.get(classId).equals(valueId);
        }
        
        return ret;
    }
    
    /**
     * Adds a word class (by class ID) to the rule filter. Only one value for a class ID can exist at once.
     * If you add -1, it will wipe the filter first, as -1
     * denotes All Classes
     * @param classId id of parent class
     * @param valueId if of value within class
     */
    public void addClassToFilterList(Integer classId, Integer valueId) {
        if (classId == -1) {
            wipeClassFilter();
            applyToClasses.put(classId, -1);
        } else if (!applyToClasses.containsKey(classId)) {
            if (applyToClasses.containsKey(-1)) { // cannot contain both All and any other selection
                applyToClasses.remove(-1);
            }
            applyToClasses.put(classId, valueId);
        } else {
            applyToClasses.replace(classId, valueId);
        }
    }
    
    /**
     * Removes a class value from the list to apply this rule to. Removes the class ID entirely from the rule if no
     * values from within it are selected
     * @param classId
     * @param valueId 
     */
    public void removeClassFromFilterList(Integer classId, Integer valueId) {
        if (applyToClasses.containsKey(classId) && applyToClasses.get(classId).equals(valueId)) {
            applyToClasses.remove(classId);
        }
    }
    
    /**
     * Wipes all classes from rule selection filter
     */
    public void wipeClassFilter() {
        applyToClasses.clear();
    }
    
    /**
     * Returns map of all word class ids that this applies to.
     * If it contains only -1, then it applies to all classes.
     * @return map of applicable word class properties: key = class ID, list = applicable value ids
     */
    public Map<Integer, Integer> getClassFilterList() {
        return applyToClasses;
    }
    
    public void writeXML(Document doc, Element rootElement) {
        Element ruleNode = doc.createElement(PGTUtil.decGenRuleXID);
        rootElement.appendChild(ruleNode);

        Element wordValue = doc.createElement(PGTUtil.decGenRuleCombXID);
        wordValue.appendChild(doc.createTextNode(this.getCombinationId()));
        ruleNode.appendChild(wordValue);

        wordValue = doc.createElement(PGTUtil.decGenRuleNameXID);
        wordValue.appendChild(doc.createTextNode(this.getName()));
        ruleNode.appendChild(wordValue);

        wordValue = doc.createElement(PGTUtil.decGenRuleRegexXID);
        wordValue.appendChild(doc.createTextNode(this.getRegex()));
        ruleNode.appendChild(wordValue);

        wordValue = doc.createElement(PGTUtil.decGenRuleTypeXID);
        wordValue.appendChild(doc.createTextNode(Integer.toString(this.getTypeId())));
        ruleNode.appendChild(wordValue);

        wordValue = doc.createElement(PGTUtil.decGenRuleIndexXID);
        wordValue.appendChild(doc.createTextNode(Integer.toString(this.getIndex())));
        ruleNode.appendChild(wordValue);

        this.getTransforms().forEach((curTransform) -> {
            curTransform.writeXML(doc, ruleNode);
        });
        
        Element applyToClassesEntry = doc.createElement(PGTUtil.decGenRuleApplyToClasses);
        
        // record each class value to apply this rule to
        applyToClasses.entrySet().forEach((curEntry) -> {
            Element applyToClassValue = doc.createElement(PGTUtil.decGenRuleApplyToClassValue);
            applyToClassValue.appendChild(doc.createTextNode(curEntry.getKey().toString() 
                    + "," + curEntry.getValue().toString()));
            applyToClassesEntry.appendChild(applyToClassValue);
        });
        
        ruleNode.appendChild(applyToClassesEntry);
    }
}
