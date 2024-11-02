package CLI;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Handler {
    private Map<String, Consumer<Commands>> commands = new HashMap<>();

    public Handler(Commands commandsObject) {
        commands.put("add product", commands -> commandsObject.createProduct());
        commands.put("list", commands -> commandsObject.list());
        commands.put("exit", commands -> commandsObject.exit());
    }

    public Consumer<Commands> getCommand(String commandName) {
        return commands.get(commandName);
    }
}
