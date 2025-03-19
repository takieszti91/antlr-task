package org.interview.model;

import java.util.ArrayList;
import java.util.List;

public class Script {
    private List<Command> commands;

    public Script(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public List<Command> getCommands() {
        return commands;
    }
}
