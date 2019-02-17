package xcore.commander.commands;


/**
 * Abstract class for all executable classes-commands
 * Field {@link #name} identification command,he is called by this name
 *
 * @author Arthur Kupriyanov
 * @version 1.1
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
     * Возвращает строку в формате:<br>
     * name: имяКоманды<br>
     *
     * @return форматированное имя и мод команды
     */
    @Override
    public String toString() {
        return String.format("name: %s", name);
    }


    /**
     * Берет хэш-код значащего поля {@link #name}
     *
     * @return хэш-код команды
     */
    @Override
    public int hashCode() {
        if (this.name == null){
            throw new CommandHasNoNameException("Команда не имеет имени!");
        }

        return this.name.hashCode();
    }


    /**
     * Объекты эквивалентны только, если поля <code>{@link #name}</code> равны
     * имеют одинаковое значение и объект является классом-наследником {@link Command}
     * @param obj сравниваемый объект
     * @return {@code true} если объекты эквивалентны; {@code false} если объекты различаются
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
