package task;

/**
 * The Deadline class represents a task with a specific deadline.
 * It extends the Task class.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructs a Deadline task with the given description and deadline time.
     *
     * @param description The description of the task.
     * @param by The deadline date-time as a string.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline of the task.
     *
     * @return The deadline of the task.
     */
    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
