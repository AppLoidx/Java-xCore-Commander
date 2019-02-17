package xcore.commander;

import xcore.commander.commands.*;
import xcore.commander.commands.Unknown;

/**
 * @author Arthur Kupriyanov
 * @version 1.0.0
 */
public class CommandDeterminant {

    public static Command getCommand(String userInput){
        userInput = userInput.split(" ")[0];
        for (Command command: CommandManager.getCommands()
             ) {
            if (command.name.equals(userInput)){
                return command;
            }
        }

        return new Unknown();
    }
}
