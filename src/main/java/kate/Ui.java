package kate;

import task.Task;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Kate. How can I assist you today?");
    }

    public void showGoodbye() {
        System.out.println("Bye! Have a nice day!");
    }

    public void showLine() {
        System.out.println("----------------------------");
    }

    public void showError(String message) {
        System.out.println("⚠ ERROR: " + message);
    }

    public void showTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in your list.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showMatchingTasks(List<Task> matchingTasks) {
        System.out.println("    ____________________________________________________________");
        if (matchingTasks.isEmpty()) {
            System.out.println("     No matching tasks found.");
        } else {
            System.out.println("     Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + matchingTasks.get(i));
            }
        }
        System.out.println("    ____________________________________________________________");
    }
}