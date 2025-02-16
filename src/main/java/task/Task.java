package task;

public class Task {
    public String description;
    protected boolean isDone;

    // Constructor to initialize a task with a description
    public Task(String description) {
        this.description = description;
        this.isDone = false; // Tasks are not done by default
    }

    // Method to mark the task as done
    public void markAsDone() {
        this.isDone = true;
    }

    // Method to mark the task as not done
    public void markAsNotDone() {
        this.isDone = false;
    }

    // Getter for isDone
    public boolean isDone() {
        return this.isDone;
    }

    // Setter for isDone
    public void setDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }
}
