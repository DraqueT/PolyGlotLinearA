module org.darisadesigns.polyglotlina.polyglot {
    // All modules labeled as automatic must be modularized
    requires commons.csv;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.swing;
    requires java.desktop;
    requires org.apache.commons.lang3; //AUT
    requires org.apache.commons.text; //AUT
    requires org.jsoup; // AUT
    requires poi; // AUT Dep: commons-collections4-4.3.jar commons-math3-3.6.1.jar commons-codec-1.13.jar commons-logging-1.2.jar
    // requires poi.ooxml; // AUT - insane number of required imports... no plausible way of doing this currently
    requires java.logging;
    
    
    exports org.darisadesigns.polyglotlina;
}