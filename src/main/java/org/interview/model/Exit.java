package org.interview.model;

public class Exit extends Command {
    @Override
    public String toString() {
        System.exit(0);
        return "Exit";
    }
}
