package org.interview.model;

import org.interview.SimpleScriptParser;

public class Print extends Command {
    public static final String WARNING_COMMANDS_ARE_NOT_ALLOWED = "Warning: Commands are not allowed inside print command!";
    private String text;

    public Print(SimpleScriptParser.PrintContext ctx, String lastResult){
        super();
        this.text = concatenateStringParameters(ctx);
        if(this.text.equals("result")){
            this.text = lastResult;
        }
    }

    private static String concatenateStringParameters(SimpleScriptParser.PrintContext ctx) {
        String text = "";
        String stringPiece = "";
        boolean allowed = true;
        for(int i = 1; i < ctx.getChildCount() && allowed; i++){
            stringPiece = ctx.getChild(1).toString();
            allowed = new StringCheck(stringPiece).isAllowed();
            if(allowed){
                if(i == 1){
                    text = ctx.getChild(i).toString();
                } else {
                    text = text + " " + ctx.getChild(i).toString();
                }
            } else {
                text = WARNING_COMMANDS_ARE_NOT_ALLOWED;
            }
        }
        return text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
