package xcore.commander;

import xcore.commander.commands.*;
import xcore.commander.commands.Unknown;

import java.util.ArrayList;

/**
 * Determines and returns command, if command name and requests first word equals
 *
 * @author Arthur Kupriyanov
 * @version 1.1.0
 */
public class CommandDeterminant {

    static Command getCommand(ArrayList<Command> commandList, String userInput){
        for (Command command : commandList){
            if (command.name.equals(userInput.split(" ")[0])){
                return command;
            }
        }

        return new Unknown();
    }
}
