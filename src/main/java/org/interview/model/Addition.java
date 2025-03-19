package org.interview.model;

public class Addition extends MathCommand {
    public Addition(int num1, int num2){
        super(num1 + num2);
    }

    public Addition(String message) {
        super(message);
    }
}
