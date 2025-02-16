package kate;

import task.Task;
import task.Todo;
import task.Deadline;
import task.Event;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_PATH = "./data/kate.txt";

    // Load tasks from file
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Check if the file exists, if not, create necessary directories
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // Create ./data directory if not exists
            return tasks; // Return an empty list since no tasks are saved yet
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                switch (type) {
                case "T" -> {
                    Todo todo = new Todo(description);
                    if (isDone) todo.markAsDone();
                    tasks.add(todo);
                }
                case "D" -> {
                    String by = parts[3];
                    Deadline deadline = new Deadline(description, by);
                    if (isDone) deadline.markAsDone();
                    tasks.add(deadline);
                }
                case "E" -> {
                    String at = parts[3];
                    Event event = new Event(description, at, "");
                    if (isDone) event.markAsDone();
                    tasks.add(event);
                }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ ERROR: Unable to read the file. Starting with an empty task list.");
        }

        return tasks;
    }

    // Save tasks to file
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(taskToFileString(task));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ ERROR: Unable to save tasks to file.");
        }
    }

    // Convert task to file string format
    private static String taskToFileString(Task task) {
        String status = task.isDone() ? "1" : "0";
        if (task instanceof Todo) {
            return "T | " + status + " | " + task.description;
        } else if (task instanceof Deadline) {
            Deadline d = (Deadline) task;
            return "D | " + status + " | " + d.description + " | " + d.getBy();
        } else if (task instanceof Event) {
            Event e = (Event) task;
            return "E | " + status + " | " + e.description + " | " + e.getFrom() + " to " + e.getTo();
        }
        return "";
    }
}

