package org.interview.model;

public class Addition extends Command {
    private int num1;
    private int num2;
    private int sum;

    public Addition(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
        this.sum = this.num1 + this.num2;
    }

    @Override
    public String toString() {
        return Integer.valueOf(this.sum).toString();
    }
}
