package org.interview.model;

public class Subraction extends Command {
    private int num1;
    private int num2;
    private int subtracted;

    public Subraction(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
        this.subtracted = this.num1 - this.num2;
    }

    @Override
    public String toString() {
        return Integer.valueOf(this.subtracted).toString();
    }
}
