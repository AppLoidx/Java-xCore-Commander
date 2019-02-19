package examples.commands;

import xcore.commander.commands.Command;
import xcore.commander.modules.common.Associator;
import xcore.commander.modules.common.KeysReader;
import xcore.commander.modules.common.WinConsoleExec;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Arthur Kupriyanov
 */
public class Browser extends Command {

    private Associator<String, String> associator = new Associator<>();

    @Override
    public String exec(String input) {
        fillAccociator();
        Map<String, String> keysMap = KeysReader.readKeys(input.split(" "));
        String link = null;

        if (keysMap.containsKey("-l") || keysMap.containsKey("--link")){
            if (keysMap.containsKey("-l")) link = keysMap.get("-l");
            else link = keysMap.get("--link");

            try {
                link = associator.getAssociation(link);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (link != null){
            try {
                WinConsoleExec.execProc("start " + link);
                return "Opening link: " + link;
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
                return "Ошибка выполнения команды " + e.toString();
            }
        }

        try {
            WinConsoleExec.execProc("start browser");
            return "Ок!";
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return "Ошибка выполнения команды " + e.toString();
        }
    }

    @Override
    protected void setName() {
        commandName = "browser";
    }

    private void fillAccociator(){

        // Google
        HashSet<String> google = new HashSet<>();
        google.add("google");
        associator.putAssociation(google, "https://google.com");

        // MyAnimeList
        HashSet<String> animelist = new HashSet<>();
        animelist.add("animelist");
        animelist.add("anime");
        associator.putAssociation(animelist, "https://myanimelist.net");

        // GitHub
        HashSet<String> github = new HashSet<>();
        github.add("git");
        github.add("github");
        github.add("gh");
        associator.putAssociation(github, "https://github.com");

    }

}
