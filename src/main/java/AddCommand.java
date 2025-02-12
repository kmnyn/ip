public class AddCommand implements Command {
    private final Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        if (task instanceof Todo) {
            Kate.addTodo(task.description);
        } else if (task instanceof Deadline deadline) {
            Kate.addDeadline(deadline.description, deadline.getBy());
        } else if (task instanceof Event event) {
            Kate.addEvent(event.description, event.getFrom(), event.getTo());
        }
    }
}
