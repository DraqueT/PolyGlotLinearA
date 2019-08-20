module org.darisadesigns.polyglotlina.polyglot {
    // All modules labeled as automatic must have 
    //requires io; // iText is poorly labeled... AUTOMATIC
    requires javafx.controls;
    requires javafx.media;
    requires javafx.swing;
    requires java.desktop;
    //requires kernel; // iText color, events, font, etc... AUTOMATIC
    //requires layout; // more iText... AUTOMATIC
    requires org.apache.commons.lang3; //AUTOMATIC - export: org.apache.commons.lang3.exception
    //requires org.apache.commons.text; //AUTOMATIC
    //requires org.apache.commons.compress; //AUTOMATIC // TODO: Do I even need this?
    requires org.jsoup; // AUTOMATIC
    requires poi; // AUTOMATIC export: export: org.apache.poi, org.apache.poi.util, org.apache.poi.hssf, org.apache.poi.hssf.usermodel, org.apache.poi.ss, org.apache.poi.ss.usermodel
    //requires poi.ooxml; // AUTOMATIC
    requires java.logging;
    
    exports org.darisadesigns.polyglotlina;
}