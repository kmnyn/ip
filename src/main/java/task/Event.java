package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;

    // Constructor that parses the date-time strings into LocalDateTime
    public Event(String description, String from, String to) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        this.from = LocalDateTime.parse(from, formatter);
        this.to = LocalDateTime.parse(to, formatter);
    }

    // Getter for 'from'
    public LocalDateTime getFrom() {
        return from;
    }

    // Getter for 'to'
    public LocalDateTime getTo() {
        return to;
    }

    @Override
    public String toString() {
        // Format the 'from' and 'to' times in the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String fromFormatted = getFrom().format(formatter);
        String toFormatted = getTo().format(formatter);

        return "[E]" + super.toString() + " (from: " + fromFormatted + " to: " + toFormatted + ")";
    }
}
