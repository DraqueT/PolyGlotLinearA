#!/bin/bash
# Constructs PolyGlot Mac package

JAVAFX_LOCATION_MAC="/Users/draque/.m2/repository/org/openjfx"
JAVAFX_VER="12.0.2"
JAVA_PACKAGER_LOCATION="/Users/draque/NetBeansProjects/jdk_14_packaging/Contents/Home/bin"  # this will go away once Java 14 drops officially...
JAR_W_DEP="PolyGlotLinA-3.0-jar-with-dependencies.jar"
JAR_WO_DEP="PolyGlotLinA-3.0.jar"

if  [ "$1" = "" ] || [ "$1" = "build" ]; then
	echo "cleaning/testing/compiling..."
	mvn clean package
fi

if [ "$1" = "" ] || [ "$1" = "clean" ] || [ "$1" = "image" ]; then
	echo "cleaning build paths..."
	rm -rf target/mods
	rm -rf build
fi
	
if [ "$1" = "" ] || [ "$1" = "image" ]; then
	echo "creating jmod based on jar built without dependencies..."
	mkdir target/mods
	$JAVA_HOME/bin/jmod create --class-path target/$JAR_WO_DEP --main-class org.darisadesigns.polyglotlina.PolyGlot target/mods/PolyGlot.jmod

	echo "creating runnable image..."
	$JAVA_HOME/bin/jlink --module-path "module_injected_jars/:target/mods:$JAVAFX_LOCATION_MAC/javafx-graphics/$JAVAFX_VER/:$JAVAFX_LOCATION_MAC/javafx-base/$JAVAFX_VER/:$JAVAFX_LOCATION_MAC/javafx-media/12.0.2/:$JAVAFX_LOCATION_MAC/javafx-swing/$JAVAFX_VER/:$JAVAFX_LOCATION_MAC/javafx-controls/$JAVAFX_VER/:$JAVA_HOME/jmods" --add-modules "org.darisadesigns.polyglotlina.polyglot","jdk.crypto.ec" --output "build/image/" --compress=2 --launcher PolyGlot=org.darisadesigns.polyglotlina.polyglot
fi

if [ "$1" = "" ] || [ "$1" = "pack" ]; then
  rm -rf appimage
  echo "packing mac app..."
  $JAVA_PACKAGER_LOCATION/jpackage --runtime-image build/image --input target --output appimage --name PolyGlot --main-jar $JAR_W_DEP --copyright "2014-2019 Draque Thompson" --description "PolyGlot is a spoken language construction toolkit." --mac-bundle-identifier "PolyGlot" --mac-bundle-name "PolyGlot"
  cp appimage/PolyGlot.app/Contents/Java/PolyGlot.cfg appimage/PolyGlot.app/Contents/PolyGlot.cfg
  rm -rf appimage/PolyGlot.app/Contents/Java
  mkdir appimage/PolyGlot.app/Contents/Java
  mv appimage/PolyGlot.app/Contents/PolyGlot.cfg appimage/PolyGlot.app/Contents/Java/PolyGlot.cfg
  rm appimage/PolyGlot.app/Contents/Info.plist
  rm appimage/PolyGlot.app/Contents/Resources/PolyGlot.icns
  cp packaging_files/PolyGlot.icns appimage/PolyGlot.app/Contents/Resources/PolyGlot.icns
  cp packaging_files/PolyGlotFile.icns appimage/PolyGlot.app/Contents/Resources/PolyGlotFile.icns
  cp packaging_files/Info.plist appimage/PolyGlot.app/Contents/Info.plist
fi

echo "Done!"
