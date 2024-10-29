package CLI;
import java.util.Scanner;

public class Commands {
    private Scanner sc;
    private boolean running = true;

    public Commands(Scanner sc) {
        this.sc = sc;
    }

    public void exit() {
        System.out.println("Hasta la próxima!");
        running = false;
    }

    public void print() {
        System.out.println("Print function.");
    }

    public boolean isRunning() {
        return running;
    }

}
