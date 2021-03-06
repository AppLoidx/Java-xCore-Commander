package xcore.commander;


import xcore.commander.commands.Command;
import xcore.commander.commands.Example;
import xcore.commander.commands.Unknown;
import xcore.commander.commands.Weather;

import java.util.ArrayList;

/**
 * @author Arthur Kupriyanov
 * @version 1.0.1
 */
public class CommandManager {
    private static ArrayList<Command> commands = new ArrayList<>();

    static {
        commands.add(new Unknown());

        // Example commands --!>

        commands.add(new Weather());
        commands.add(new Example());
    }

    public static void addCommand(Command command){ commands.add(command);}
    static ArrayList<Command> getCommands(){
        return commands;
    }
}
