package command;

import kate.Kate;
import kate.KateException;
import task.Task;

public class DeleteCommand implements Command {
    private int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        try {
            // Validate index
            if (taskIndex < 1 || taskIndex > Kate.tasks.size()) {
                throw new KateException("Invalid task number.");
            }

            // Remove task
            Task removedTask = Kate.tasks.remove(taskIndex - 1);

            // Display confirmation
            System.out.println("    ____________________________________________________________");
            System.out.println("     Noted. I've removed this task:");
            System.out.println("       " + removedTask);
            System.out.println("     Now you have " + Kate.tasks.size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
        } catch (KateException e) {
            System.out.println("    ____________________________________________________________");
            System.out.println("     Error: " + e.getMessage());
            System.out.println("    ____________________________________________________________");
        }
    }
}
