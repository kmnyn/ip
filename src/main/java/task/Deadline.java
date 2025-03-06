package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The Deadline class represents a task with a specific deadline.
 * It extends the Task class.
 */
public class Deadline extends Task {
    protected LocalDateTime deadline;

    /**
     * Constructs a Deadline task with the given description and deadline time.
     *
     * @param description The description of the task.
     * @param by The deadline date-time as a string.
     */
    public Deadline(String description, String by) {
        super(description);
        this.deadline = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"));
    }

    /**
     * Returns the deadline of the task.
     *
     * @return The deadline of the task.
     */
    public LocalDateTime getBy() {
        return deadline;
    }
    @Override
    public String toString() {
        // Format the deadline in "MMM dd yyyy HH:mm" format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "[D]" + super.toString() + " (by: " + deadline.format(formatter) + ")";
    }
}