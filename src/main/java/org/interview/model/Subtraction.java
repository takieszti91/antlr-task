package org.interview.model;

public class Subtraction extends MathCommand {
    public Subtraction(int num1, int num2){
        super(num1 - num2);
    }

    public Subtraction(String message){
        super(message);
    }
}
