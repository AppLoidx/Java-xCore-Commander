package xcore.commander;


import xcore.commander.commands.Command;
import xcore.commander.commands.Unknown;

import java.util.ArrayList;

/**
 * @author Arthur Kupriyanov
 * @version 1.0.0
 */
public class CommandManager {
    private static ArrayList<Command> commands = new ArrayList<>();

    static {
        commands.add(new Unknown());
    }

    public static void addCommand(Command command){ commands.add(command);}
    public static ArrayList<Command> getCommands(){
        return commands;
    }
}
