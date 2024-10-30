package CLI;

import java.util.Scanner;
import java.util.function.Consumer;

public class Cli {
    private Scanner sc = new Scanner(System.in);
    private Commands commands = new Commands(sc);
    private Handler handler;

    public Cli() {
        handler = new Handler(commands);
    }

    public void run() {
        while (commands.isRunning()) {
            System.out.print("> ");
            String[] input = readCommands();
            execute(input);
        }
        sc.close();
    }

    public String[] readCommands() {
        String input = sc.nextLine().toLowerCase();
        return input.split(" ");
    }

    private void execute(String[] input) {
        if (input.length > 0) {
            String command = String.join(" ", input);
            Consumer<Commands> action = handler.getCommand(command);

            if (action != null) {
                action.accept(commands);
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
