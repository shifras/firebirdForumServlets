# Servlet driven basic web forum app
Basic forum app immitation using firebird database using basic servlet/DAO/Scriplet structure

# Installation
### Prior to this installation it is assumed that you have tomcat 9.0 and firebird3.0 server preinstalled.
1. Download zip
2. Extract to a filesystem.
3. In Eclipse IDE open src/main/java/lt.bit.db/Firebird.java
4. Add full path to the database file `forum.fdb` which is locate in root of this project e.g 
`jdbc:firebirdsql://localhost:3050//home/<yourUsername>/ForumJSP/forum.fdb","SYSDBA","masterkey");`
5. Add runtime as Apache 9.0 in project->properties->Targeted runtimes provide your apache 9.0 installation path
6. Right click on project name->Run as->Run on server
7. #### Enjoy!
