package org.interview.model;

import org.interview.SimpleScriptParser;

public class Print extends Command {
    private String text;

    public Print(SimpleScriptParser.PrintContext ctx, String lastResult){
        super();
        this.text = concatenateStringParameters(ctx);
        if(text.equals("result")){
            this.text = lastResult;
        } else {
            this.text = text;
        }
    }

    private static String concatenateStringParameters(SimpleScriptParser.PrintContext ctx) {
        String text = "";
        if(ctx.getChildCount() > 1) {
            text = text + ctx.getChild(1).toString();
            for (int i = 2; i < ctx.getChildCount(); i++) {
                text = text + " " + ctx.getChild(i).toString();
            }
        }
        return text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
