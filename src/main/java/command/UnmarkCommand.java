package command;

import kate.KateException;
import kate.TaskList;
import kate.Ui;

public class UnmarkCommand implements Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            // Unmark the task as not done
            taskList.unmarkTask(taskIndex - 1);
            System.out.println("    ____________________________________________________________");
            System.out.println("     Nice! I've unmarked this task as not done:");
            System.out.println("       " + taskList.getTasks().get(taskIndex - 1));
            System.out.println("    ____________________________________________________________");
        } catch (KateException e) {
            System.out.println("    ____________________________________________________________");
            System.out.println("     Error: " + e.getMessage());
            System.out.println("    ____________________________________________________________");
        }
    }

}

