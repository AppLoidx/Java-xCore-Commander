package consoletest;


import examples.commands.Browser;
import examples.commands.Start;
import xcore.commander.Commander;

import java.util.Scanner;

/**
 * Connected to the Commander console
 *
 * @author Arthur Kupriyanov
 */
public class Console {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);       // for input

        // --------- adding commands ------------
        Commander.addCommand(new MyCommandExample());   // custom command
        Commander.addCommand(new Start());
        Commander.addCommand(new Browser());
        // ADD YOUR COMMANDS LIKE HERE...
        // --------------------------------------

        // Mainloop
        String input;
        while(!(input=scanner.nextLine()).equals("exit")){
            System.out.println(Commander.getResponse(input));
        }
    }
}
