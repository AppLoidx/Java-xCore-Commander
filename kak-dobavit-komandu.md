# Как добавить команду?

## Добавление команды в CommandManager

CommandManager служит хранилищем команд. 

Чтобы добавить туда команду, необходимо использовать метод:

> addCommand\(Command c\)

**Пример добавления команд:**

```java
Commander.addCommand(new MyCommandExample());   // custom command
Commander.addCommand(new Start());
Commander.addCommand(new Browser());
```

{% hint style="info" %}
[https://github.com/AppLoidx/Java-xCore-Commander/tree/master/src/consoletest](https://github.com/AppLoidx/Java-xCore-Commander/tree/master/src/consoletest)
{% endhint %}

