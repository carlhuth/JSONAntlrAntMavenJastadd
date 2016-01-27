JSONAntlrAntMavenJastadd
=========================
JSONAntlrAntMavenJastadd is a Java application that
parses and performs an analysis over [JSON][json] files.

This software package is an example [Eclipse][eclipse]
package that using the following technologies:

1. [ANTLR4][antlr4]
2. [JastAdd][jastadd]
3. [Apache Maven][maven]
4. [Apache Ant][ant]
5. [ANTLR 4 Maven plugin][antlr4_maven_plugin]
6. [Jastadd Eclipse Plugin][jastadd_eclipse_plugin]
for syntax highlighting for file types used by the JastAdd system
in Eclipse.
7. [ANTLR 4 Eclipse plugin][antlr4_eclipse_plugin]
for syntax highlighting of ANTLR 4 grammar files in Eclipse.
8. [JUnit][junit] for running Unit tests.

The purpose of this software package is to provide a
sample application that demonstrates how to implement
a source code analysis by:

1. Parsing source files with ANTLR4 and creating a
[concrete syntax tree][cst] (CST).
2. Implementing a program analysis over an
[abstract syntax tree][ast] (AST) using JastAdd.
3. Implementing a [Visitor][visitor_pattern] over an
ANTLR4 CST to generate a corresponding JastAdd AST.
4. Using Maven to hook in the library dependencies for
   running both ANTLR4 and ANT from the command line
   and from the Eclipse IDE.
5. Calling an ANT script from a Maven POM file
   by following [these steps][call_ant_from_maven]. 


Software Dependencies Installation and Troubleshooting Tips
------------------------------------------------------------
Compiling and using the Eclipse IDE to edit this software
package requires installing software dependencies such
as Maven.
Not all of the dependencies listed above need to be manually
installed because some may be included in your Eclipse
installation.
This section provides instructions for installing the
required dependencies. 


### Eclipse Plugins
Not all of the Eclipse plugin dependencies listed above
need to be manually installed because some may
be included in your Eclipse installation.
Only the following Eclipse plugins *probably* need to be
manually installed.

1. [Jastadd Eclipse Plugin][jastadd_eclipse_plugin]
2. [ANTLR 4 Eclipse plugin][antlr4_eclipse_plugin]

Tips for installing the ANTLR 4 Eclipse plugin are below.

### ANTLR 4 Eclipse Plugin depends on Xtext 2.7.3
This Eclipse package has been tested with commit version
`b5a38e75ef06d0ebd25361c8e9e1cd51062e0287` of the
ANTLR 4 Eclipse Plugin.
This version depends on version 2.7.3 of [Xtext][xtext].
The following steps installs that version of Xtext:

1. Download the zip archive of Xtext 2.7.3 from this
[webpage][xtext_download_page].
2. From Eclipse Window, select the downloaded zip file for
installing new Eclipse plugins:
 - `Help` -> `Install New Software` -> `Add...` -> `Archive...`
 - Check Xtext for installation in the popup window and follow
    the instructions for installation.
  
### ANTLR 4 Maven Plugin Execution with Eclipse Troubleshooting Tip
For some Eclipse installations,
the ANTLR 4 Maven Plugin does not execute in Eclipse without performing
additional steps not listed on the ANTLR 4 Maven
plugin [webpage][antlr4_maven_plugin].
Specifically, the ANTLR 4 plugin caused Eclipse to print
the following error message:
`Plugin execution not covered by lifecycle configuration`.
If that error message occurs, this
this StackOverflow
[webpage][plugin_execution_not_covered]
discusses how to solve that problem.

Building JSONAntlrAntMavenJastadd
------------------------------------
To compile this software package, perform the following
steps:

1. Execute the ANT build script `build.xml` in directory
`JSONAntlrAntMavenJastadd/src/main/jastadd`.
This script can be executed two different ways:
    1. From the Eclipse window by,
     Right-clicking the default target -> `Run As` -> `Ant Build`.
    2. From the command line,
     execute `ant` from `JSONAntlrAntMavenJastadd/src/main/jastadd`.
2. Run the Maven build script `pom.xml` from directory `JSONAntlrAntMavenJastadd`
   with the Maven goal `compile`.
   This script can be done two different ways:
    1. From the Eclipse window by,
     Right-clicking the Project Directory -> `Run As` -> `Maven Build` ->
     Enter goal `compile` in the `Goals:` textbox of the pop-up window.
    2. From the command line,
     execute `mvn compile` from `JSONAntlrAntMavenJastadd`.
3. Right-clicking the Project Directory -> `Refresh`

Executing the steps above should generate the required
source files and compile all of the source files of
`JSONAntlrAntMavenJastadd`.

### Single build step
If building `JSONAntlrAntMavenJastadd` from the command line,
executing `maven compile` is the only step needed to build
the application.
Unfortunately, running the Maven build script from some Eclipse
installations does not in turn run the
ANT script
`JSONAntlrAntMavenJastadd/src/main/jastadd/build.xml`,
which will cause compilation errors.
Specifically, if this ANT script did not execute,
executing `maven compile` will generate an error message
that includes the phrase "package AST does not exist".
Executing this ANT script runs JastAdd to generate the source
files that perform the program analysis.
To run this ANT script manually, either execute `ant` from
`JSONAntlrAntMavenJastadd/src/main/jastadd`
or execute this script from the Eclipse window by
Right-clicking the default target -> `Run As` -> `Ant Build`.


Running Sample Application using JSONAntlrAntMavenJastadd
----------------------------------------------------------
[JUnit][junit] tests that utilize the `JSONAntlrAntMavenJastadd`
are in file
`JSONAntlrAntMavenJastadd/src/test/java/parser/TestJSONParser.java`.
To execute the JUnit tests in that file from Eclipse:
in the Package Explorer,
Right-click the file -> `Run As` -> `JUnit Test`.


[json]: http://www.json.org/
[eclipse]: http://www.eclipse.org/
[antlr4]: https://github.com/antlr/antlr4/blob/master/doc/index.md
[jastadd]: http://jastadd.org/web/
[maven]: https://maven.apache.org/
[ant]: http://ant.apache.org/
[cst]: https://en.wikipedia.org/wiki/Parse_tree
[ast]: https://en.wikipedia.org/wiki/Abstract_syntax_tree
[visitor_pattern]: https://en.wikipedia.org/wiki/Visitor_pattern
[antlr4_maven_plugin]: http://www.antlr.org/api/maven-plugin/latest/
[call_ant_from_maven]: https://books.sonatype.com/mcookbook/reference/ch04s03.html
[jastadd_eclipse_plugin]: http://jastadd.org/web/tool-support/syntax-highlighting.php
[antlr4_eclipse_plugin]: https://github.com/jknack/antlr4ide
[junit]: http://junit.org/
[plugin_execution_not_covered]: http://stackoverflow.com/questions/6352208/how-to-solve-plugin-execution-not-covered-by-lifecycle-configuration-for-sprin
[xtext]: https://eclipse.org/Xtext/
[xtext_download_page]: http://www.eclipse.org/downloads/download.php?file=/modeling/tmf/xtext/downloads/drops/2.7.3/R201411190455/tmf-xtext-Update-2.7.3.zip

