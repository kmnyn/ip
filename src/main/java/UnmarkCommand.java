public class UnmarkCommand implements Command {
    private final int taskIndex;

    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        Kate.unmarkTask(taskIndex);  // Unmark the task
    }
}
