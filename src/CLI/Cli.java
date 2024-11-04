package CLI;

import java.util.Scanner;
import java.util.function.Consumer;

public class Cli {
    private Scanner sc = new Scanner(System.in);
    private Commands commands = new Commands(sc);
    private Handler handler;

    /**
     * Constructs a new Cli object.
     *
     * This constructor initializes the Cli object by
     * creating a new Handler object.
     *
     */
    public Cli() {
        handler = new Handler(commands);
    }

    /**
     * Starts the CLI (command-line interface) and keeps it running until
     * it's stopped by the user.
     *
     * Inside the loop, the method reads the commands and executes them.
     */
    public void run() {
        while (commands.isRunning()) {
            System.out.print("> ");
            String[] input = readCommands();
            execute(input);
        }
        sc.close();
    }

    /**
     * Reads user input commands and converts them to lowercase to
     * make them case unsensitive.
     *
     * @return an array of strings where each element is a word from the input command
     */
    private String[] readCommands() {
        String input = sc.nextLine().toLowerCase();
        return input.split(" ");
    }

    /**
     * Executes a command if it's known by the handler.
     * If the command is unrecognized by the handler, it displays a message
     * indicating that the command is unknown.
     *
     * @param input An array of strings representing the commands.
     */
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
