package xcore.commander.commands;


/**
 * Abstract class for all executable classes-commands
 * Field {@link #name} identification command,he is called by this name
 *
 * @author Arthur Kupriyanov
 * @version 1.2
 */
public abstract class Command {
    protected String commandName;
    public final String name;

    {
        setName();
        if (commandName == null){
            throw new CommandHasNoNameException("Command doesn't have valid overriding of setName() method");
        }
        name = commandName;
    }

    /**
     * Command execute
     *
     * @return response
     */
    public abstract String exec(String input);

    protected abstract void setName();

    /**
     * Returns string as format:<br>
     * "name": command_name<br>
     *
     * @return "name" : <code>command_name({@link #name})</code>
     */
    @Override
    public String toString() {
        return String.format("name: %s", name);
    }


    /**
     * Берет хэш-код значащего поля {@link #name}
     *
     * @return hashCode of significant field
     */
    @Override
    public int hashCode() {
        if (this.name == null){
            throw new CommandHasNoNameException("Command has no name");
        }

        return this.name.hashCode();
    }


    /**
     * Objects equivalents if fields <code>{@link #name}</code> equals
     * and object extends {@link Command}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Command){
            return name.equals(((Command) obj).name);
        }
        return false;
    }

    private class CommandHasNoNameException extends NullPointerException{
        CommandHasNoNameException(String msg){
            super(msg);
        }
    }
}
