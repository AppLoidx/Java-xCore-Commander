package xcore.commander;

import xcore.commander.commands.*;
import xcore.commander.commands.Unknown;

/**
 * Определяет перечисление команды
 *
 * @author Артур Куприянов
 * @version 1.0.0
 */
public class CommandDeterminant {

    /**
     * По значению перечисления возвращаем команду
     * @return возвращает объект команды
     */
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
