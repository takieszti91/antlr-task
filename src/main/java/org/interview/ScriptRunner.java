package org.interview;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.interview.SimpleScriptLexer;
import org.interview.model.AntlrToScript;
import org.interview.model.Command;
import org.interview.model.Script;

import java.io.IOException;

public class ScriptRunner {
    public static void main(String[] args) {
        try {
            CharStream charStream = CharStreams.fromFileName("example.simpleScript");
            SimpleScriptLexer simpleScriptLexer = new SimpleScriptLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(simpleScriptLexer);
            SimpleScriptParser simpleScriptParser = new SimpleScriptParser(commonTokenStream);

            ParseTree parseTree = simpleScriptParser.script();
            /*
            for(int i=0; i<parseTree.getChildCount(); i++){
                ParseTree child = parseTree.getChild(i);
                for(int j=0; j<child.getChildCount(); j++){
                    ParseTree grandChild = child.getChild(j);
                    for(int k=0; k<grandChild.getChildCount(); k++){
                        System.out.println(grandChild.getChild(k));
                    }
                }
            }
            */
            AntlrToScript scriptVisitor = new AntlrToScript();
            Script script = scriptVisitor.visit(parseTree);

            for(Command command : script.getCommands()){
                if(command != null) {
                    System.out.println(command);
                }
            };


            /*
            simpleScriptParser.setBuildParseTree(true);
            ParserRuleContext tree = simpleScriptParser.script();
            System.out.println(tree.getPayload());
            */
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
