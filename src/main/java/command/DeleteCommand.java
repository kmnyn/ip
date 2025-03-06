package command;

import kate.KateException;
import task.Task;
import kate.TaskList;
import kate.Ui;

public class DeleteCommand implements Command {
    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        try {
            // Validate index
            if (taskIndex < 1 || taskIndex > taskList.getTasks().size()) {
                throw new KateException("Invalid task number.");
            }

            // Remove task
            Task removedTask = taskList.getTasks().remove(taskIndex - 1);

            // Display confirmation
            System.out.println("    ____________________________________________________________");
            System.out.println("     Noted. I've removed this task:");
            System.out.println("       " + removedTask);
            System.out.println("     Now you have " + taskList.getTasks().size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
        } catch (KateException e) {
            System.out.println("    ____________________________________________________________");
            System.out.println("     Error: " + e.getMessage());
            System.out.println("    ____________________________________________________________");
        }
    }
}
