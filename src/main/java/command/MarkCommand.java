package command;

import kate.Kate;

public class MarkCommand implements Command {
    private final int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        Kate.markTask(taskIndex);  // Mark the task
    }
}
