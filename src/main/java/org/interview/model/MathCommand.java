package org.interview.model;

public class MathCommand extends Command{
    private int result;
    private String message = "";

    public MathCommand(String message) {
        this.message = message;
    }

    public MathCommand(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        if(message.isEmpty()){
            return Integer.valueOf(this.result).toString();
        } else{
            return this.message;
        }
    }
}
