# Medium-Level-Java-Programs-
A wide range of intermediate level  programs written in Java. One of the programs 'FlightSchedule' was written during the past Google HashCode 2016 Competition. 

When you build Java application project that has a main class, the IDE
automatically copies all of the JAR files on the projects classpath to your projects dist/lib folder. The IDE
also adds each of the JAR files to the Class-Path element in the application
JAR files manifest file (MANIFEST.MF).

    To run this project from the command line, go to the dist folder and
    type the following:

      java -jar "name of the program" .jar 

To distribute this project, zip up the whole folders (including the lib folders)
and distribute the ZIP file.

Notes:

    * If two JAR files on the project classpath have the same name, only the first
    JAR file is copied to the lib folder.
    * Only JAR files are copied to the lib folder.
    If the classpath contains other types of files or folders, these files (folders)
    are not copied.
    * If a library on the projects classpath also has a Class-Path element
    specified in the manifest,the content of the Class-Path element has to be on
    the projects runtime path.
    * To set a main class in a standard Java project, right-click the project node
    in the Projects window and choose Properties. Then click Run and enter the
    class name in the Main Class field. Alternatively, you can manually type the
    class name in the manifest Main-Class element.
    

Best Luck!!!

    Regards
    
    Deen Adam
