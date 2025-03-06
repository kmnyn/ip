package kate;

// Importing commands
import command.Command;
import command.ExitCommand;


public class Kate {
    private final Ui ui;
    private final TaskList taskList;

    public Kate() {
        this.ui = new Ui();
        this.taskList = new TaskList(Storage.loadTasks());
    }

    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        while (isRunning) {
            try {
                ui.showLine();
                String input = ui.readCommand();
                Command command = Parser.parse(input);
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
