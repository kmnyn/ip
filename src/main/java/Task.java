public class Task {
    protected String description;
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
    public void unmark() {
        this.isDone = false;
    }

    // Method to return the status icon based on whether the task is done
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // Display [X] for done, [ ] for not done
    }

    // Getter for the task description
    public String getDescription() {
        return description;
    }
}
