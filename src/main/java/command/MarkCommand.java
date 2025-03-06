package command;


import kate.KateException;
import kate.TaskList;
import kate.Ui;

public class MarkCommand implements Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            // Mark the task as done
            taskList.markTask(taskIndex - 1);
            System.out.println("    ____________________________________________________________");
            System.out.println("     Nice! I've marked this task as done:");
            System.out.println("       " + taskList.getTasks().get(taskIndex - 1));
            System.out.println("    ____________________________________________________________");
        } catch (KateException e) {
            System.out.println("    ____________________________________________________________");
            System.out.println("     Error: " + e.getMessage());
            System.out.println("    ____________________________________________________________");
        }
    }
}
