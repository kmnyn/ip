package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDateTime deadline;

    public Deadline(String description, String by) {
        super(description);
        this.deadline = LocalDateTime.parse(by, DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"));
    }

    // Getter for the deadline
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