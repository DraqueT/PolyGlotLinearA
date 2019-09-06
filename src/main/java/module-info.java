module org.darisadesigns.polyglotlina.polyglot {
    // All modules labeled as automatic must be modularized
    requires commons.csv;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.swing;
    requires java.desktop;
    requires org.apache.commons.lang3; //AUT - fixed with module injector
    requires org.apache.commons.text; //AUT - fixed with module injector
    requires org.jsoup; // AUT - fixed with module injector
    requires java.logging;
    
    
    exports org.darisadesigns.polyglotlina;
}