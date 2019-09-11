/*
 * Copyright (c) 2014-2019, Draque Thompson, draquemail@gmail.com
 * All rights reserved.
 *
 * Licensed under: Creative Commons Attribution-NonCommercial 4.0 International Public License
 * See LICENSE.TXT included with this code to read the full license agreement.
 *
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

package org.darisadesigns.polyglotlina;

import org.darisadesigns.polyglotlina.CustomControls.InfoBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.swing.ImageIcon;
import org.darisadesigns.polyglotlina.Screens.ScrFamilies;
import org.darisadesigns.polyglotlina.Screens.ScrGrammarGuide;
import org.darisadesigns.polyglotlina.Screens.ScrIPARefChart;
import org.darisadesigns.polyglotlina.Screens.ScrLexicon;
import org.darisadesigns.polyglotlina.Screens.ScrLogoDetails;
import org.darisadesigns.polyglotlina.Screens.ScrQuizGenDialog;

/**
 * This contains various constant vales in PolyGlot
 * @author draque
 */
public class PGTUtil {
    private static File java8BridgeLocation = null;
    public static final String DICTIONARY_XID = "dictionary";
    public static final String PGVERSION_XID = "PolyGlotVer";
    public static final String DICTIONARY_SAVE_DATE = "DictSaveDate";
    
    // properties on words
    public static final String LEXICON_XID = "lexicon";
    public static final String WORD_XID = "word";
    public static final String LOCALWORD_XID = "localWord";
    public static final String CONWORD_XID = "conWord";
    public static final String WORD_POS_ID_XID = "wordTypeId";
    public static final String WORD_ID_XID = "wordId";
    public static final String WORD_PROCOVERRIDE_XID = "wordProcOverride";
    public static final String WORD_DEF_XID = "definition";
    public static final String WORD_AUTODECLOVERRIDE_XID = "autoDeclOverride";
    public static final String WORD_PROC_XID = "pronunciation";
    public static final String WORD_RULEORVERRIDE_XID = "wordRuleOverride";
    public static final String WORD_CLASSCOLLECTION_XID = "wordClassCollection";
    public static final String WORD_CLASS_AND_VALUE_XID = "wordClassification";
    public static final String WORD_CLASS_TEXT_VAL_COLLECTION_XID = "wordClassTextValueCollection";
    public static final String WORD_CLASS_TEXT_VAL_XID = "wordClassTextValue";
    public static final String WORD_ETY_NOTES_XID = "wordEtymologyNotes";

    // properties for types/parts of speech
    public static final String POS_COLLECTION_XID = "partsOfSpeech";
    public static final String POS_XID = "class";
    public static final String POS_NAME_XID = "className";
    public static final String POS_ID_XID = "classId";
    public static final String POS_NOTES_XID = "classNotes";
    public static final String POS_PROC_MAN_XID = "pronunciationMandatoryClass";
    public static final String POS_DEF_MAN_XID = "definitionMandatoryClass";
    public static final String POS_PATTERN_XID = "classPattern";
    public static final String POS_GLOSS_XID = "classGloss";

    // language properties
    public static final String langPropertiesXID = "languageProperties";
    public static final String fontConXID = "fontCon";
    public static final String fontLocalXID = "fontLocal";
    public static final String langPropLangNameXID = "langName";
    public static final String langPropFontSizeXID = "fontSize";
    public static final String langPropFontStyleXID = "fontStyle";
    public static final String langPropLocalFontSizeXID = "localFontSize";
    public static final String langPropAlphaOrderXID = "alphaOrder";
    public static final String langPropTypeMandatoryXID = "langPropTypeMandatory";
    public static final String langPropLocalMandatoryXID = "langPropLocalMandatory";
    public static final String langPropWordUniquenessXID = "langPropWordUniqueness";
    public static final String langPropLocalUniquenessXID = "langPropLocalUniqueness";
    public static final String langPropIgnoreCaseXID = "langPropIgnoreCase";
    public static final String langPropDisableProcRegexXID = "langPropDisableProcRegex";
    public static final String langPropEnforceRTLXID = "langPropEnforceRTL";
    public static final String langPropAuthCopyrightXID = "langPropAuthorCopyright";
    public static final String langPropLocalLangNameXID = "langPropLocalLangName";
    public static final String langPropUseLocalLexicon = "langPropUseLocalLexicon";
    public static final String langPropKerningVal = "langPropKerningValue";
    public static final String langPropOverrideRegexFont ="langPropOverrideRegexFont";
    
    // character replacement pair values
    public static final String langPropCharRepContainerXID = "langPropCharRep";
    public static final String langPropCharRepNodeXID = "langPropCharRepNode";
    public static final String langPropCharRepCharacterXID = "langPropCharRepCharacter";
    public static final String langPropCharRepValueXID = "langPropCharRepValue";

    // declension properties
    public static final String declensionCollectionXID = "declensionCollection";
    public static final String declensionXID = "declensionNode";
    public static final String declensionIdXID = "declensionId";
    public static final String declensionTextXID = "declensionText";
    public static final String declensionComDimIdXID = "combinedDimId";
    public static final String declensionNotesXID = "declensionNotes";
    public static final String declensionIsTemplateXID = "declensionTemplate";
    public static final String declensionRelatedIdXID = "declensionRelatedId";
    public static final String declensionIsDimensionless = "declensionDimensionless";

    // dimensional declension properties
    public static final String dimensionNodeXID = "dimensionNode";
    public static final String dimensionIdXID = "dimensionId";
    public static final String dimensionNameXID = "dimensionName";

    // pronunciation properties
    public static final String etymologyCollectionXID = "etymologyCollection";
    public static final String proGuideXID = "proGuide";
    public static final String proGuideBaseXID = "proGuideBase";
    public static final String proGuidePhonXID = "proGuidePhon";
    public static final String proGuideRecurseXID = "proGuideRecurse";
    
    // romanization properties
    public static final String romGuideXID = "romGuide";
    public static final String romGuideEnabledXID = "romGuideEnabled";
    public static final String romGuideNodeXID = "romGuideNode";
    public static final String romGuideBaseXID = "romGuideBase";
    public static final String romGuidePhonXID = "romGuidePhon";
    public static final String romGuideRecurseXID = "romGuideRecurse";

    // family properties
    public static final String famNodeXID = "thesNode";
    public static final String famNotesXID = "thesNotes";
    public static final String famNameXID = "thesName";
    public static final String famWordXID = "thesWord";

    // autodeclansion generation properties
    public static final String decGenRuleXID = "decGenRule";
    public static final String decGenRuleTypeXID = "decGenRuleTypeId";
    public static final String decGenRuleCombXID = "decGenRuleComb";
    public static final String decGenRuleRegexXID = "decGenRuleRegex";
    public static final String decGenRuleNameXID = "decGenRuleName";
    public static final String decGenRuleIndexXID = "decGenRuleIndex";
    public static final String decGenRuleApplyToClasses = "decGenRuleApplyToClasses";
    public static final String decGenRuleApplyToClassValue = "decGenRuleApplyToClassValue";

    // autodeclension transform properties
    public static final String decGenTransXID = "decGenTrans";
    public static final String decGenTransRegexXID = "decGenTransRegex";
    public static final String decGenTransReplaceXID = "decGenTransReplace";

    // constructed declension dimension properties
    public static final String decCombinedFormSectionXID = "decCombinedFormSection";
    public static final String decCombinedFormXID = "decCombinedForm";
    public static final String decCombinedIdXID = "decCombinedId";
    public static final String decCombinedSurpressXID = "decCombinedSurpress";

    // properties for logographs
    public static final String logoRootNoteXID = "logoRootNode";
    public static final String logoGraphsCollectionXID = "logoGraphsCollection";
    public static final String logoStrokesXID = "logoStrokes";
    public static final String logoNotesXID = "logoNotes";
    public static final String logoIsRadicalXID = "logoIsRadical";
    public static final String logoRadicalListXID = "logoRadicalList";
    public static final String logoReadingXID = "logoReading";
    public static final String logoGraphValueXID = "logoGraphValue";
    public static final String logoGraphIdXID = "logoGraphId";
    public static final String logoGraphNodeXID = "LogoGraphNode";
    public static final String logoWordRelationXID = "LogoWordRelation";
    public static final String logoRelationsCollectionXID = "LogoRelationsCollection";

    // properties for the grammar dictioary
    public static final String grammarSectionXID = "grammarCollection";
    public static final String grammarChapterNodeXID = "grammarChapterNode";
    public static final String grammarChapterNameXID = "grammarChapterName";
    public static final String grammarSectionsListXID = "grammarSectionsList";
    public static final String grammarSectionNodeXID = "grammarSectionNode";
    public static final String grammarSectionNameXID = "grammarSectionName";
    public static final String grammarSectionRecordingXID = "grammarSectionRecordingXID";
    public static final String grammarSectionTextXID = "grammarSectionText";

    // properties for word classes
    public static final String ClassesNodeXID = "wordGrammarClassCollection";
    public static final String ClassXID = "wordGrammarClassNode";
    public static final String ClassIdXID = "wordGrammarClassID";
    public static final String ClassNameXID = "wordGrammarClassName";
    public static final String ClassApplyTypesXID = "wordGrammarApplyTypes";
    public static final String ClassIsFreetextXID = "wordGrammarIsFreeTextField";
    public static final String ClassValuesCollectionXID = "wordGrammarClassValuesCollection";
    public static final String ClassValueNodeXID = "wordGrammarClassValueNode";
    public static final String ClassValueNameXID = "wordGrammarClassValueName";
    public static final String ClassValueIdXID = "wordGrammarClassValueId";
    
    // etymology constants
    public static final String EtyCollectionXID = "EtymologyCollection";
    public static final String EtyIntRelationNodeXID = "EtymologyInternalRelation";
    public static final String EtyIntChildXID = "EtymologyInternalChild";
    public static final String EtyChildExternalsXID = "EtymologyChildToExternalsNode";
    public static final String EtyExternalWordNodeXID = "EtymologyExternalWordNode";
    public static final String EtyExternalWordValueXID = "EtymologyExternalWordValue";
    public static final String EtyExternalWordOriginXID = "EtymologyExternalWordOrigin";
    public static final String EtyExternalWordDefinitionXID = "EtymologyExternalWordDefinition";
    
    // TODO Node constants
    public static final String ToDoLogXID = "ToDoLog";
    public static final String ToDoNodeXID = "ToDoNodeHead";
    public static final String ToDoNodeDoneXID = "ToDoNodeDone";
    public static final String ToDoNodeLabelXID = "ToDoNodeLabel";
    public static final String ToDoNodeColorXID = "ToDoNodeColor";
    public static final String ToDoRoot = "ToDoRoot";

    // constants for PolyGlot options found in PolyGlot.ini
    public static final int optionsNumLastFiles = 5;
    public static final String optionsLastFiles = "LastFiles";
    public static final String optionsScreenPos = "ScreenPositions";
    public static final String optionsScreensSize = "ScreenSizes";
    public static final String optionsScreensOpen = "ScreensUp";
    public static final String optionsAutoResize = "OptionsResize";
    public static final String optionsMenuFontSize = "OptionsMenuFontSize";
    public static final String optionsNightMode = "OptionsNightMode";
    public static final String optionsReversionsCount = "OptionsReversionCount";
    public static final String optionsToDoDividerLocation = "ToDoDividerLocation";

    // Java 8 bridge constants
    public static final String JAVA8_JAVA_COMMAND = "java";
    public static final String JAVA8_JAR_ARG = "-jar";
    public static final String JAVA8_VERSION_ARG = "--version";
    public static final String JAVA8_BRIDGERESOURCE = "/assets/org/DarisaDesigns/java_8_bridge.zip";
    public static final String JAVA8_JAR = "PolyGlot_J8_Bridge.jar";
    public static final String JAVA8_JAR_FOLDER = "dist";
    public static final String JAVA8_PDFCOMMAND = "pdf-export";
    public static final String JAVA8_EXCELTOCVSCOMMAND = "excel-to-cvs";
    public static final String JAVA8_EXPORTTOEXCELCOMMAND = "export-to-excel";
    
    // string constants
    public static final String dictFileName = "PGDictionary.xml";
    public static final String conFontFileName = "conLangFont";
    public static final String localFontFileName = "localLangFont";
    public static final String LCDFontLocation = "/assets/org/DarisaDesigns/FontAssets/lcdFont.ttf";
    public static final String UnicodeFontLocation = "/assets/org/DarisaDesigns/FontAssets/CharisSIL-Regular.ttf";
    public static final String UnicodeFontBoldLocation = "/assets/org/DarisaDesigns/FontAssets/CharisSIL-Bold.ttf";
    public static final String UnicodeFontItalicLocation = "/assets/org/DarisaDesigns/FontAssets/CharisSIL-Italic.ttf";
    public static final String UnicodeFontBoldItalicLocation = "/assets/org/DarisaDesigns/FontAssets/CharisSIL-BoldItalic.ttf";
    public static final String UnicodeFontFamilyName = "Charis SIL";
    public static final String ButtonFontLocation = "/assets/org/DarisaDesigns/FontAssets/buttonFont.ttf";
    public static final String logoGraphSavePath = "logoGraphs/";
    public static final String imagesSavePath = "images/";
    public static final String grammarSoundSavePath = "grammarSounds/";
    public static final String reversionSavePath = "reversion/";
    public static final String reversionBaseFileName = "reversionXMLFile";
    public static final String errorLogFile = "PolyGlot_error_log.log";
    public static final String emptyFile = "<EMPTY>";
    public static final String tempFile = "xxTEMPPGTFILExx";
    public static final String polyGlotFont = "PolyGlot";
    public static final String conLangFont = "PolyGlotConlangGrammarFont";
    public static final String polyGlotIni = "PolyGlot.ini";
    public static final String emptyLogoImage = "/assets/org/DarisaDesigns/ImageAssets/EmptyImage.png";
    public static final String IPAOtherSounds = "/assets/org/DarisaDesigns/ImageAssets/IPA_Other.png";
    public static final String treeNodeImage = "/assets/org/DarisaDesigns/ImageAssets/treeNode.png";
    public static final String notFoundImage = "/assets/org/DarisaDesigns/ImageAssets/not-found.png";
    public static final String polyGlotAbout = "/assets/org/DarisaDesigns/ImageAssets/PolyGlot_About.png";
    public static final String polyGlotEaster = "/assets/org/DarisaDesigns/ImageAssets/n0rara_draque.png";
    public static final String TESTRESOURCES = "src/test/java/TestResources/";
    
    public static final String playButtonUp = "/assets/org/DarisaDesigns/ImageAssets/play_OFF_BIG.png";
    public static final String playButtonDown = "/assets/org/DarisaDesigns/ImageAssets/play_ON_BIG.png";
    public static final String recordButtonUp = "/assets/org/DarisaDesigns/ImageAssets/recording_OFF_BIG.png";
    public static final String recordButtonDown = "/assets/org/DarisaDesigns/ImageAssets/recording_ON_BIG.png";
    public static final String addButton = "/assets/org/DarisaDesigns/ImageAssets/add_button.png";
    public static final String deleteButton = "/assets/org/DarisaDesigns/ImageAssets/delete_button.png";
    public static final String addButtonPressed = "/assets/org/DarisaDesigns/ImageAssets/add_button_pressed.png";
    public static final String deleteButtonPressed = "/assets/org/DarisaDesigns/ImageAssets/delete_button_pressed.png";
    public static final String ipa_vowels = "/assets/org/DarisaDesigns/ImageAssets/IPA_Vowels.png";
    public static final String pulmonic_consonants = "/assets/org/DarisaDesigns/ImageAssets/IPA_Pulmonic_Consonants.png";
    public static final String non_pulmonic_consonants = "/assets/org/DarisaDesigns/ImageAssets/IPA_NonPulmonicConsonants.png";
    public static final String ipa_other ="/assets/org/DarisaDesigns/ImageAssets/IPA_Other.png";
    public static final String mainMenuBG = "/assets/org/DarisaDesigns/ImageAssets/PolyGlotBG.png";
    
    public static final String ipaSoundsLocation = "/assets/org/DarisaDesigns/SoundAssets/";
    public static final String RTLMarker = "\u202e";
    public static final String LTRMarker = "\u202c";
    public static final String ImageIdAttribute = "imageIDAttribute";
    public static final String True = "T";
    public static final String False = "F";
    public static final String displayName = "PolyGlot";
    public static final String homePage = "http://draquet.github.io/PolyGlot/";

    // screen names when they're required as constants...
    public static final String scrNameLexicon;
    public static final String scrNameGrammar;
    public static final String scrNameLogo;
    public static final String scrNameFam;
    public static final String scrIPARefChart;
    public static final String scrQuizGenDialog;
    
    // numeric constants...
    public static final Integer numMenuFlashes = 4;
    public static final Integer menuFlashSleep = 200;
    public static final Double defaultFontSize = 12.0;
    public static final int maxProcRecursion = 100;
    public static final int defaultMaxRollbackVersions = 10;
    public static final int maxFilePathLength = 1000;
    public static final int maxLogCharacters = 25000;
    
    // color constants
    public static final Color colorDisabledBG;
    public static final Color colorEnabledBG;
    public static final Color colorSelectedBG;
    public static final Color colorDisabledForeground;
    public static final Color colorMouseoverBorder;
    public static final Color colorText;
    public static final Color colorDefaultText;
    public static final Color colorDefaultTextNight;
    public static final Color colorTextBG;
    public static final Color colorTextNight;
    public static final Color colorTextBGNight;
    public static final Color colorTextDisabled;
    public static final Color colorTextDisabledBG;
    public static final Color colorTextDisabledNight;
    public static final Color colorTextDisabledBGNight;
    public static final Color colorCheckboxSelected;
    public static final Color colorCheckboxBackground;
    public static final Color colorCheckboxOutline;
    public static final Color colorCheckboxHover;
    public static final Color colorCheckboxClicked;
    public static final Color colorCheckBoxFieldBack;
    public static final Color colorCheckboxSelectedNight;
    public static final Color colorCheckboxBackgroundNight;
    public static final Color colorCheckboxOutlineNight;
    public static final Color colorCheckboxHoverNight;
    public static final Color colorCheckboxClickedNight;
    public static final Color colorCheckBoxFieldBackNight;
    public static final Color colorCheckboxSelectedDisabled;
    public static final Color colorCheckboxBackgroundDisabled;
    public static final Color colorCheckboxOutlineDisabled;
    public static final Color colorCheckboxHoverDisabled;
    public static final Color colorCheckboxClickedDisabled;
    public static final Color colorCheckBoxFieldBackDisabled;
    
    // visual style constants
    public static final int checkboxRounding = 3;
    
    // UI Elements to set on OSX (copy/paste/cut)
    public static final String[] inputMaps = {"Button.focusInputMap",
                "CheckBox.focusInputMap",
                "ComboBox.ancestorInputMap",
                "EditorPane.focusInputMap",
                "FileChooser.ancestorInputMap",
                "FormattedTextField.focusInputMap",
                "List.focusInputMap",
                "PasswordField.focusInputMap",
                "RadioButton.focusInputMap",
                "RootPane.ancestorInputMap",
                "ScrollBar.ancestorInputMap",
                "ScrollPane.ancestorInputMap",
                "Slider.focusInputMap",
                "Spinner.ancestorInputMap",
                "SplitPane.ancestorInputMap",
                "TabbedPane.ancestorInputMap",
                "TabbedPane.focusInputMap",
                "Table.ancestorInputMap",
                "TableHeader.ancestorInputMap",
                "ToolBar.ancestorInputMap",
                "Tree.ancestorInputMap",
                "TextArea.focusInputMap",
                "TextField.focusInputMap",
                "TextPane.focusInputMap",
                "ToggleButton.focusInputMap",
                "Tree.focusInputMap"};

    // images and icons that only need to be loaded once
    public static final ImageIcon addButtonIcon;
    public static final ImageIcon delButtonIcon;
    public static final ImageIcon addButtonIconPressed;
    public static final ImageIcon delButtonIconPressed;
    public static final ImageIcon polyGlotIcon;
    
    // Fonts stored here to cache values single time
    public static final Font PMenuFont;
    
    public static final boolean isOSX;
    public static final boolean isWindows;
    
    // one time set for code driven static values
    static {
        colorDisabledBG = Color.decode("#b0b0b0");
        colorEnabledBG = Color.decode("#66b2ff");
        colorSelectedBG = Color.decode("#7979ef");
        colorDisabledForeground = Color.decode("#808080");
        colorMouseoverBorder = Color.decode("#909090");
        colorText = Color.decode("#000000");
        colorTextBG = Color.decode("#ffffff");
        colorTextNight = Color.decode("#ffffff");
        colorTextBGNight = Color.decode("#000000");
        colorDefaultText = Color.lightGray;
        colorDefaultTextNight = Color.darkGray;
        colorTextDisabled = Color.lightGray;
        colorTextDisabledBG = Color.darkGray;
        colorTextDisabledNight = Color.lightGray;
        colorTextDisabledBGNight = Color.darkGray;
        colorCheckboxSelected = Color.black;
        colorCheckboxBackground = Color.white;
        colorCheckboxOutline = Color.black;
        colorCheckboxHover = Color.black;
        colorCheckboxClicked = Color.lightGray;
        colorCheckBoxFieldBack = Color.white;
        colorCheckboxSelectedNight = Color.gray;
        colorCheckboxBackgroundNight = Color.black;
        colorCheckboxOutlineNight = Color.darkGray;
        colorCheckboxHoverNight = Color.lightGray;
        colorCheckboxClickedNight = Color.white;
        colorCheckBoxFieldBackNight = Color.black;
        colorCheckboxSelectedDisabled = Color.gray;
        colorCheckboxBackgroundDisabled = Color.lightGray;
        colorCheckboxOutlineDisabled = Color.gray;
        colorCheckboxHoverDisabled = Color.darkGray;
        colorCheckboxClickedDisabled = Color.darkGray;
        colorCheckBoxFieldBackDisabled = Color.gray;
        
        // loads default font on system error (never came up, but for completeness...)
        Font tmpFont;
        try {
            tmpFont = PFontHandler.getMenuFont();
        } catch (IOException e) {
            InfoBox.error("PolyGlot Load Error", "Unable to load default button font.", null);
            IOHandler.writeErrorLog(e, "Initilization error (PGTUtil)");
            tmpFont = javax.swing.UIManager.getDefaults().getFont("Label.font");
        }
        PMenuFont = tmpFont;
        
        scrNameLexicon = ScrLexicon.class.getName();
        scrNameGrammar = ScrGrammarGuide.class.getName();
        scrNameLogo = ScrLogoDetails.class.getName();
        scrNameFam = ScrFamilies.class.getName();
        scrIPARefChart = ScrIPARefChart.class.getName();
        scrQuizGenDialog = ScrQuizGenDialog.class.getName();
        
        addButtonIcon = new ImageIcon(new ImageIcon(
                    PGTUtil.class.getResource("/assets/org/DarisaDesigns/ImageAssets/add_button.png"))
                    .getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH));
        delButtonIcon = new ImageIcon(new ImageIcon(
                PGTUtil.class.getResource("/assets/org/DarisaDesigns/ImageAssets/delete_button.png"))
                .getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH));
        addButtonIconPressed = new ImageIcon(new ImageIcon(
                PGTUtil.class.getResource("/assets/org/DarisaDesigns/ImageAssets/add_button_pressed.png"))
                .getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH));
        delButtonIconPressed = new ImageIcon(new ImageIcon(
                PGTUtil.class.getResource("/assets/org/DarisaDesigns/ImageAssets/delete_button_pressed.png"))
                .getImage().getScaledInstance(21, 21, Image.SCALE_SMOOTH));
        polyGlotIcon = new ImageIcon(
                PGTUtil.class.getResource("/assets/org/DarisaDesigns/ImageAssets/PolyGlotIcon.png"));
        
        isOSX = isOSX();
        isWindows = isWindows();
    }
    
    /**
     * This records the mode of a given PDialog or PFrame window. Defaults to
     * STANDARD
     */
    public enum WindowMode {
        STANDARD, SINGLEVALUE, SELECTLIST
    }

    /**
     * Encapsulates a string in RTL characters, setting back to LTR after
     * @param encapsulate string to encapsulate
     * @return encapsulated string
     */
    public static String encapsulateRTL(String encapsulate) {
        return RTLMarker + encapsulate + LTRMarker;
    }

    /**
     * Strips string of RTL and LTR markers
     * @param strip string to strip
     * @return stripped string
     */
    public static String stripRTL(String strip) {
        return strip.replace(RTLMarker, "").replace(LTRMarker, "");
    }
    
    /**
     * Adds attributes to fontmapping
     * @param key Key value
     * @param value value-value
     * @param font font to add value to
     * @return newly derived font
     */
    @SuppressWarnings("unchecked") // No good way to do this in a type safe manner.
    public static Font addFontAttribute(Object key, Object value, Font font) {
        Map attributes = font.getAttributes();
        attributes.put(key, value);
        return font.deriveFont(attributes);
    }
    
    /**
     * Tests and returns true if running OSX
     * @return 
     */
    private static boolean isOSX() {
        return System.getProperty("os.name").startsWith("Mac");
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").startsWith("Win");
    }

    /**
    * Checks that the position is in bounds for the screen and places it in visible
    * area if not
     * @param w
    */
    public static void checkPositionInBounds(Window w) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point location = w.getLocationOnScreen();

        // if this would appear offscreen, simply place it in the center of the screen
        if (screenSize.getWidth() < location.x || screenSize.getHeight() < location.y) {
            w.setLocationRelativeTo(null);
        }
    }
    
    /**
     * Gets Java8 bridge class location. Caches value.
     * @return 
     * @throws java.io.IOException 
     */
    public static File getJava8BridgeLocation() throws IOException {
        if (java8BridgeLocation == null || !java8BridgeLocation.exists()) {
            java8BridgeLocation = Java8Bridge.getNewJavaBridgeLocation();
        }
        
        return java8BridgeLocation;
    }
}