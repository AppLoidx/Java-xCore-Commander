package xcore.commander;

/**
 * @author Arthur Kupriyanov
 */
public class Commander {
    public static String getResponse(String request){
        return CommandDeterminant.getCommand(CommandManager.getCommands(), request).exec(request);
    }

}
