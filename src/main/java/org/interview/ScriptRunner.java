package org.interview;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.interview.model.AntlrToScript;
import org.interview.model.Command;
import org.interview.model.Script;

import java.io.IOException;

public class ScriptRunner {
    public static void main(String[] args) {
        try {
            // CharStream charStream = CharStreams.fromFileName("example.simpleScript");
            CharStream charStream = CharStreams.fromFileName("exampleMalicious.simpleScript");
            SimpleScriptLexer simpleScriptLexer = new SimpleScriptLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(simpleScriptLexer);
            SimpleScriptParser simpleScriptParser = new SimpleScriptParser(commonTokenStream);

            ParseTree parseTree = simpleScriptParser.script();
            AntlrToScript scriptVisitor = new AntlrToScript();
            Script script = scriptVisitor.visit(parseTree);

            for(Command command : script.getCommands()){
                if(command != null) {
                    System.out.println(command);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
