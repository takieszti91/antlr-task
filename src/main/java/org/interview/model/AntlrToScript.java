package org.interview.model;

import org.interview.SimpleScriptBaseVisitor;
import org.interview.SimpleScriptParser;

public class AntlrToScript extends SimpleScriptBaseVisitor<Script> {
    @Override
    public Script visitScript(SimpleScriptParser.ScriptContext ctx) {
        Script script = new Script();

        AntlrToCommand commandVisitor = new AntlrToCommand();
        for (int i=0; i<ctx.getChildCount()-1; i++){
            script.addCommand(commandVisitor.visit(ctx.getChild(i)));
        }

        return script;
    }
}
