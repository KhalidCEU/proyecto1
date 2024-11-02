package app;
import CLI.Cli;

public class Main {
    /**
     * Entrypoint of the program.
     *
     * It creates a {@link Cli} object and calls its {@link Cli#run()}
     * method to start the CLI (command-line interface).
     *
     * @param args The command line arguments (unused).
     */
    public static void main(String args[]) {
        Cli cli = new Cli();
        cli.run();
    }
}
