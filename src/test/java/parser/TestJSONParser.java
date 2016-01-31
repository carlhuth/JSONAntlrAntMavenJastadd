package parser;
import static org.junit.Assert.*;

import org.junit.Test;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.JSONParser.JsonContext;

import AST.*;

public class TestJSONParser
{
	@Test
	public void test1ASTFactory() throws java.io.IOException {
		String fileName = "json-examples/example1.json";
		ANTLRInputStream input = new ANTLRFileStream(fileName);

        // create a lexer that feeds off of input CharStream
        JSONLexer lexer = new JSONLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        JSONParser parser = new JSONParser(tokens);

        JsonContext tree = (JsonContext) parser.json();
        // print LISP-style tree
        System.out.println(tree.toStringTree(parser));
        
        ASTFactory factory = new ASTFactory();
        JsonProgram p = (JsonProgram) tree.accept(factory);
        int numStringLiterals = p.numStringValues() ;
        System.out.println("Number of string literals: "
          + numStringLiterals);
        assertTrue(numStringLiterals > 0);
	}

	@Test
	public void test2ASTFactory() throws java.io.IOException {
		String fileName = "json-examples/example2.json";
		ANTLRInputStream input = new ANTLRFileStream(fileName);

        // create a lexer that feeds off of input CharStream
        JSONLexer lexer = new JSONLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        JSONParser parser = new JSONParser(tokens);

        JsonContext tree = (JsonContext) parser.json();
        // print LISP-style tree
        System.out.println(tree.toStringTree(parser));
        
        ASTFactory factory = new ASTFactory();
        JsonProgram p = (JsonProgram) tree.accept(factory);
        int numStringLiterals = p.numStringValues() ;
        System.out.println("Number of string values: "
          + numStringLiterals);
        assertTrue(numStringLiterals > 0);
	}
}
