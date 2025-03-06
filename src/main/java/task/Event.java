package task;

/**
 * The Event class represents a task with a specific time range (from-to).
 * It extends the Task class.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Constructs an Event task with the given description and time range.
     *
     * @param description The description of the task.
     * @param from The start time of the event as a string.
     * @param to The end time of the event as a string.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start time of the event.
     *
     * @return The start time of the event.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Returns the end time of the event.
     *
     * @return The end time of the event.
     */
    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
