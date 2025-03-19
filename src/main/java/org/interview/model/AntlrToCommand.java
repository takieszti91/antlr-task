package org.interview.model;

import org.interview.SimpleScriptBaseVisitor;
import org.interview.SimpleScriptParser;

public class AntlrToCommand extends SimpleScriptBaseVisitor<Command> {
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
        Addition sum = new Addition(Integer.valueOf(ctx.getChild(1).toString()), Integer.valueOf(ctx.getChild(2).toString()));
        this.lastResult = sum.toString();
        return sum;
    }

    @Override
    public Command visitSubtraction(SimpleScriptParser.SubtractionContext ctx) {
        Subraction subraction = new Subraction(Integer.valueOf(ctx.getChild(1).toString()), Integer.valueOf(ctx.getChild(2).toString()));
        this.lastResult = subraction.toString();
        return subraction;
    }

    @Override
    public Command visitExit(SimpleScriptParser.ExitContext ctx) {
        return new Exit();
    }
}
