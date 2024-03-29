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
package org.darisadesigns.polyglotlina.QuizEngine;

import org.darisadesigns.polyglotlina.DictCore;
import org.darisadesigns.polyglotlina.Nodes.ConWord;
import org.darisadesigns.polyglotlina.Nodes.DictNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author draque.thompson
 */
public class QuizQuestion extends DictNode {
    protected List<DictNode> multipleChoices = new ArrayList<>();
    private DictNode answer;
    private QuestionType type;
    private final DictCore core;
    private DictNode source;
    private DictNode userAnswer;
    private Answered answered = Answered.Unanswered;
    
    /**
     * Constructor for quiz questions
     * @param _core The core of your dictionary
     */
    public QuizQuestion(DictCore _core) {
        core = _core;
        userAnswer = new ConWord();
        userAnswer.setId(-1);
    }
    
    /**
     * DO NOT CALL THIS.
     * @param _node WILL THROW ERROR
     * @throws ClassCastException EVERY DAMN TIME, FOOL.
     */
    @Override
    public void setEqual(DictNode _node) throws ClassCastException {
        multipleChoices = ((QuizQuestion)_node).multipleChoices;
        answer = ((QuizQuestion)_node).getAnswer();
        type = ((QuizQuestion)_node).getType();
        source = ((QuizQuestion)_node).source;
    }
    
    /**
     * Adds a choice to the multiple choice selection
     * @param choice 
     */
    public void addChoice(DictNode choice) {
        multipleChoices.add(choice);
    }
    
    public void setType(QuestionType _type) {
        type = _type;
    }
    
    public QuestionType getType() {
        return type;
    }
    
    /**
     * Gets potential answers (if any) in randomized order
     * @return 
     */
    public List<DictNode> getChoices() {
        long seed = System.nanoTime();
        Collections.shuffle(multipleChoices, new Random(seed));
        return multipleChoices;
    }
    
    /**
     * DO NOT CALL THIS.
     * @return A BIG OL' DUMP.
     * @throws ClassCastException EVERY DAMN TIME, FOOL.
     */
    @Override
    public String getValue() {
        throw new UnsupportedOperationException("USE GETQUESTIONVALUE() METHOD"); 
    }
    
    /**
     * Returns constructed string question value UNLESS there is an override value
     * set. Then ignores construction and uses override. Never includes text that 
     * might be written in the ConLang's font.
     * @return String form of posed question.
     * @throws java.lang.Exception
     */
    public String getQuestionValue() throws Exception {
        String ret;
        
        if (value.length() != 0) {
            ret = value;
        } else {
            if (source instanceof ConWord) {
                ConWord ansWord = (ConWord)source;
                ret = "What is this word's ";
                String qEnd = "";
                switch (type) {
                    case ConEquiv:
                        qEnd += core.conLabel() + " equivalent?";
                        break;
                    case Local:
                        qEnd += core.localLabel() + " equivalent?";
                        break;
                    case PoS:
                        qEnd += "part of speech?";
                        break;
                    case Proc:
                        qEnd += "pronunciation?";
                        break;
                    case Def:
                        qEnd += "definition?";
                        break;
                    case Classes:
                        for (Entry<Integer, Integer> curEntry : ansWord.getClassValues()) {
                            if (qEnd.length() != 0) {
                                qEnd += "/";
                            }
                            
                            qEnd += core.getWordPropertiesCollection().getNodeById(curEntry.getKey());
                        }
                        
                        qEnd += " classification?";
                        break;
                    default:
                        throw  new Exception("Unhandled type: " + type);
                }
                ret += qEnd;
            } else {
                ret = "UNSUPPORTED TYPE: " + answer.getClass().getName();
            }
        }
        
        return ret;
    }
    
    /**
     * Tests answer. Must be given in the form of a DictBode of some type
     * @param proposed proposed answer
     * @return 
     * @throws java.lang.Exception on answer type mismatch
     */
    public boolean testAnswer(DictNode proposed) throws Exception {
        boolean ret;
        
        if (proposed instanceof ConWord) {
            if (answer instanceof ConWord) {
                ConWord propWord = (ConWord)proposed;
                ConWord ansWord = (ConWord)answer;
                boolean ignoreCase = core.getPropertiesManager().isIgnoreCase();
                switch (type) {
                    case Local:                        
                        if (ignoreCase) {
                            ret = ansWord.getLocalWord().equalsIgnoreCase(propWord.getLocalWord());
                        } else {
                            ret = ansWord.getLocalWord().equals(propWord.getLocalWord());
                        }
                        break;
                    case PoS:
                        ret = Objects.equals(ansWord.getWordTypeId(), propWord.getWordTypeId());
                        break;
                    case Proc:
                        if (ignoreCase) {
                            ret = ansWord.getPronunciation().equalsIgnoreCase(propWord.getPronunciation());
                        } else {
                            ret = ansWord.getPronunciation().equals(propWord.getPronunciation());
                        }
                        break;
                    case Def:
                        if (ignoreCase) {
                            ret = ansWord.getDefinition().equalsIgnoreCase(propWord.getDefinition());
                        } else {
                            ret = ansWord.getDefinition().equals(propWord.getDefinition());
                        }
                        break;
                    case Classes:
                        Set<Entry<Integer, Integer>> propClasses = propWord.getClassValues();
                        Set<Entry<Integer, Integer>> ansClasses = ansWord.getClassValues();
                        
                        if (propClasses.size() != ansClasses.size()) {
                            ret = false;
                        } else {
                            ret = true;
                            for (Entry<Integer, Integer> e : propClasses) {
                                if (!Objects.equals(ansWord.getClassValue(e.getKey()), e.getValue())) {
                                    ret = false;
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        throw new Exception("Unknown question type for ConWord object: " + type.name());
                }
            } else {
                throw new Exception("Answer type mismatch. " + answer.getClass().getName() 
                        + " vs. " + proposed.getClass().getName());
            }
        } else {
            throw new Exception("Answer for checking type " + proposed.getClass().getName() 
                    + " not yet implemented.");
        }
        
        return ret;
    }
    
    public DictNode getAnswer() {
        return answer;
    }
    
    public void setAnswer(DictNode _answer) {
        answer = _answer;
    }
    
    /**
     * @return the source
     */
    public DictNode getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(DictNode source) {
        this.source = source;
    }

    /**
     * @return the answered status (not, correct, incorrect)
     */
    public Answered getAnswered() {
        return answered;
    }

    /**
     * @param answered the answered to set
     */
    public void setAnswered(Answered answered) {
        this.answered = answered;
    }

    /**
     * @return the userAnwer
     */
    public DictNode getUserAnswer() {
        return userAnswer;
    }

    /**
     * @param userAnswer the userAnwer to set
     */
    public void setUserAnswer(DictNode userAnswer) {
        this.userAnswer = userAnswer;
    }
 
    public enum QuestionType {
        Local, PoS, Proc, Def, Classes, ConEquiv
    }
    
    public enum Answered {
        Unanswered, Correct, Incorrect
    }
}
