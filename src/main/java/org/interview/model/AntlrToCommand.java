package org.interview.model;

import org.interview.SimpleScriptBaseVisitor;
import org.interview.SimpleScriptParser;

public class AntlrToCommand extends SimpleScriptBaseVisitor<Command> {
    public static final String WARNING_ONLY_NUMBERS_ARE_ALLOWED = "Warning: Only numbers are allowed for addition and subtraction!";
    String lastResult = "";

    @Override
    public Command visitCommand(SimpleScriptParser.CommandContext ctx) {
        return super.visitCommand(ctx);
    }

    @Override
    public Command visitPrint(SimpleScriptParser.PrintContext ctx) {
        return new Print(ctx, this.lastResult);
    }

    @Override
    public Command visitAddition(SimpleScriptParser.AdditionContext ctx) {
        Addition sum;
        try {
            sum = new Addition(Integer.parseInt(ctx.getChild(1).toString()), Integer.parseInt(ctx.getChild(2).toString()));
            this.lastResult = sum.toString();
        } catch (NumberFormatException e) {
            sum = new Addition(WARNING_ONLY_NUMBERS_ARE_ALLOWED);
        }
        return sum;
    }

    @Override
    public Command visitSubtraction(SimpleScriptParser.SubtractionContext ctx) {
        Subtraction subtraction;
        try {
            subtraction = new Subtraction(Integer.parseInt(ctx.getChild(1).toString()), Integer.parseInt(ctx.getChild(2).toString()));
            this.lastResult = subtraction.toString();
        } catch (NumberFormatException e){
            subtraction = new Subtraction(WARNING_ONLY_NUMBERS_ARE_ALLOWED);
        }
        return subtraction;
    }

    @Override
    public Command visitExit(SimpleScriptParser.ExitContext ctx) {
        return new Exit();
    }
}
