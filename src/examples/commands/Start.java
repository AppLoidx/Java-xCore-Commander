package examples.commands;

import xcore.commander.commands.Command;
import java.io.*;

/**
 * @author Arthur Kupriyanov
 */
public class Start extends Command {

    @Override
    public String exec(String input) {
        String element = input.split(" ")[1];

        try {
            Process p = Runtime.getRuntime().exec("cmd /c start browser");
            p.waitFor();
            p.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Ошибка выполнения!";
        }
        return "Ok!";
    }

    @Override
    protected void setName() {
        commandName = "start";
    }
}
