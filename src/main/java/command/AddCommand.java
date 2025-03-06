package command;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;
import kate.TaskList;
import kate.Ui;

public class AddCommand implements Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        if (task instanceof Todo) {
            taskList.addTask(task);
            System.out.println("    ____________________________________________________________");
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + task); // Correctly print the added task
            System.out.println("     Now you have " + taskList.getTasks().size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
        } else if (task instanceof Deadline deadline) {
            taskList.addTask(task);
            System.out.println("    ____________________________________________________________");
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + task); // Correctly print the added task
            System.out.println("     Now you have " + taskList.getTasks().size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
        } else if (task instanceof Event event) {
            taskList.addTask(task);
            System.out.println("    ____________________________________________________________");
            System.out.println("     Got it. I've added this task:");
            System.out.println("       " + task); // Correctly print the added task
            System.out.println("     Now you have " + taskList.getTasks().size() + " tasks in the list.");
            System.out.println("    ____________________________________________________________");
        }
    }
}
