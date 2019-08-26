#!/bin/bash
echo "cleaning/compiling..."
mvn clean package
# TODO: Figure out how to translate this functionality into the context of a maven built project
echo "cleaning build paths..."
rm -rf target/mods
rm -rf build
mkdir target/mods

echo "creating jmod based on jar built without dependencies..."
jmod create --class-path target/PolyGlotLinA-3.0.jar --main-class org.darisadesigns.polyglotlina.PolyGlot target/mods/PolyGlot.jmod

echo "creating runnable image..."
jlink --module-path "module_injected_jars/:/Users/draque/.m2/repository/com/itextpdf/kernel/7.1.7:/Users/draque/.m2/repository/org/apache/poi/poi-ooxml/4.1.0/poi-ooxml-4.1.0.jar:/Users/draque/.m2/repository/org/apache/poi/poi/4.1.0/:/Users/draque/.m2/repository/com/itextpdf/layout/7.1.7/:target/mods:/Users/draque/.m2/repository/org/openjfx/javafx-graphics/12.0.2/:/Users/draque/.m2/repository/org/openjfx/javafx-base/12.0.2/:/Users/draque/.m2/repository/org/openjfx/javafx-media/12.0.2/:/Users/draque/.m2/repository/org/openjfx/javafx-swing/12.0.2/:/Users/draque/.m2/repository/org/openjfx/javafx-controls/12.0.2/:/Users/draque/.sdkman/candidates/java/12.0.1.j9-adpt/jmods/" --add-modules "org.darisadesigns.polyglotlina.polyglot" --output "build/image/" --launcher PolyGlot=org.darisadesigns.polyglotlina.polyglot

echo "Done!"
