package consoletest;

import xcore.commander.Commander;

import java.util.Scanner;

/**
 * Connected to the Commander console
 *
 * @author Arthur Kupriyanov
 */
public class Console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while(!(input=scanner.nextLine()).equals("exit")){
            System.out.println(Commander.getResponse(input));
        }
    }
}
