package xcore.commander.modules.common;

import java.io.IOException;

/**
 * @author Arthur Kupriyanov
 */
public class WinConsoleExec {
    public static void execProc(String command) throws InterruptedException, IOException {
        Process p = Runtime.getRuntime().exec("cmd /c " + command);
        p.waitFor();
        p.destroy();
    }
}
