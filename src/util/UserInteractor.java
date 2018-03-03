package util;

import java.util.Scanner;

/**
 * User: Anna Kuzmenko
 */
public class UserInteractor implements IUserInteractor {
    Scanner in = new Scanner(System.in);

    @Override
    public String readCommand() {
        String command = in.nextLine();
        System.out.println("<< " + command);
        return command;
    }

    @Override
    public void print(String output) {
        System.out.println("Terminal: " + output);

    }

    @Override
    public void getHelp() {
        String string = "List of command: \n" +
                        "Create new playlist:          \"Create new playlist\" \n" +
                        "Add song in playlist:         \"Add song\" \n" +
                        "Add several song in playlist: \"Add several songs\" \n" +
                        "Remove song of playlist:      \"Remove song\" \n" +
                        "Sort playlist:                \"Sort playlist\" \n" +
                        "Rename playlist:              \"Rename playlist\" \n" +
                        "If you want to quit:          \"End\" \n";
        print(string);
    }
}
