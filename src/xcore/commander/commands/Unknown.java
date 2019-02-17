package xcore.commander.commands;

/**
 * @author Arthur Kupriyanov
 */
public class Unknown extends Command {

    @Override
    public String exec(String args) {
        return "Unknown command";
    }

    @Override
    protected void setName() {
        commandName = "Lul Kek";
    }
}
