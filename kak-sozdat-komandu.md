# Как создать команду?

## Суперкласс Command

Для начала необходимо наследоваться от класса Commander

```java
class MyCommand extends Command
```

{% hint style="info" %}
 [https://github.com/AppLoidx/Java-xCore-Commander/blob/master/src/xcore/commander/commands/Command.java](https://github.com/AppLoidx/Java-xCore-Commander/blob/master/src/xcore/commander/commands/Command.java)
{% endhint %}

Следует обратить внимание на методы:

* **setName\(\)**

```java
protected abstract void setName();
```

В этом методе необходимо в поле commandName присвоить имя команды \(идентификатор\). Таким образом, интерпретатор команд \(CommandDeterminant\) будет производить выборку по значению этого поля.

Пример реализации:

```java
@Override
    protected void setName() {
        commandName = "example-name";
    }
```

* **exec\(\)**

```java
public abstract String exec(String input);
```

Этот метод инициализирует команду. После выборки команды вызывается этот метод, который должен вернуть ответ пользователю.

Пример реализации:

```java
@Override
    public String exec(String args) {
        return "Command has been called!";
    }
```

### Листинг команды Example

```java
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
```

