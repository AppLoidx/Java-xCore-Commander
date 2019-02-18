package consoletest;

import xcore.commander.commands.Command;

/**
 * @author Arthur Kupriyanov
 */
public class MyCommandExample extends Command {
    @Override
    public String exec(String input) {
        return "You called a custom command";
    }

    @Override
    protected void setName() {
        commandName = "myCommand";
    }
}
