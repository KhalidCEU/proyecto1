package CLI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Handler {
    private Map<String, Consumer<Commands>> commands = new HashMap<>();

    /**
     * Constructs a new Handler object.
     *
     * This constructor fills the commands HashMap with key value pairs,
     * where the key is the command string and the value is a Consumer that
     * executes the corresponding method from the Commands object.
     *
     * @param commandsObject The Commands object containing the methods to
     * execute for each command.
     */
    public Handler(Commands commandsObject) {
        commands.put("add product", commands -> commandsObject.createProduct());
        commands.put("list", commands -> commandsObject.list());
        commands.put("exit", commands -> commandsObject.exit());
    }

    /**
     * Finds the method to execute that's associated to the given
     * command name.
     *
     * This allows the CLI to recognize and execute comamands inside the
     * {@link Cli} class.
     *
     * @param commandName The name of the command to find.
     * @return A {@link Consumer<Commands>} object that represents the method
     * to execute for the given command, or null if the command isn't found.
     */
    public Consumer<Commands> getCommand(String commandName) {
        return commands.get(commandName);
    }
}
