package kate;

// Importing commands
import command.Command;
import command.ExitCommand;

/**
 * The main application class that runs the task management program.
 * It handles user input, processes commands, and displays outputs.
 */
public class Kate {
    private final Ui ui;
    private final TaskList taskList;

    /**
     * Constructs a Kate instance that initializes the user interface and task list.
     */
    public Kate() {
        this.ui = new Ui();
        this.taskList = new TaskList(Storage.loadTasks());
    }

    /**
     * Runs the main application loop, reading commands from the user and executing them.
     * The loop continues until the exit command is given.
     */
    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            try {
                ui.showLine();
                String input = ui.readCommand();
                Command command = Parser.parse(input, taskList);
                command.execute(taskList, ui);
                if (command instanceof ExitCommand) {
                    isRunning = false;
                }
            } catch (KateException e) {
                ui.showError(e.getMessage());
            }
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new Kate().run();
    }
}
