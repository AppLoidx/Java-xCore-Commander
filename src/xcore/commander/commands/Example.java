package xcore.commander.commands;

/**
 * Example command
 * @author Arthur Kupriyanov
 */
public class Example extends Command {

    @Override
    public String exec(String input) {
        // set realization of this command here...
        return "This is example command!";
    }

    @Override
    protected void setName() {

        // set command name here ...
        commandName = "Example";

        // if you don't set this field - command throws an exception
    }

    /*
    Don't forget to add this command on CommandManager like as commands.add(new Example());
     */
}
