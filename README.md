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


Installing Eclipse Plugin Dependencies
----------------------------------------
Not all of the plugin dependencies listed above
need to be manually installed because some may
be included in your Eclipse installation.
Only the following dependencies *probably* need to be
manually installed.

1. [Jastadd Eclipse Plugin][jastadd_eclipse_plugin]
2. [ANTLR 4 Eclipse plugin][antlr4_eclipse_plugin]


ANTLR Maven Plugin Execution with Eclipse Troubleshooting Tip
--------------------------------------------------------------
For some users, the ANTLR 4 Maven Plugin did not execute in
Eclipse without performing additional steps not listed on the
ANTLR 4 Maven plugin [webpage][antlr4_maven_plugin].
Specifically, the ANTLR 4 plugin caused Eclipse to print
the following error message:
`Plugin execution not covered by lifecycle configuration`.
If that error message occurs, this
this StackOverflow
[webpage][plugin_execution_not_covered]
discusses how to solve that problem.


Building JSONAntlrAntMavenJastadd
------------------------------------
Executing the following command should generate source
files and compile all of the source files of
JSONAntlrAntMavenJastadd.

    maven compile

Sometimes running that command does not in turn run the
ANT script
`JSONAntlrAntMavenJastadd/src/main/jastadd/build.xml`,
which will cause compilation errors.
Specifically, if this ANT script did not execute,
executing `maven compile` will generate an error message
that includes the phrase "package AST does not exist".
Running this ANT script generates source files required
to perform the program analysis.
To run this ANT script manually, either execute
`ant` from `JSONAntlrAntMavenJastadd/src/main/jastadd`
or execute this script from the Eclipse window by
Right-clicking the default target -> `Run As` -> `Ant Build`.


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
[jastadd_eclipse_plugin]: http://jastadd.org/update-site/eclipse-syntax
[antlr4_eclipse_plugin]: https://github.com/jknack/antlr4ide
[junit]: http://junit.org/
[plugin_execution_not_covered]: http://stackoverflow.com/questions/6352208/how-to-solve-plugin-execution-not-covered-by-lifecycle-configuration-for-sprin

