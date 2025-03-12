package kate;

import task.Task;
import task.Todo;
import task.Deadline;
import task.Event;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_PATH = "./data/kate.txt";  // Path to the file

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
                String[] parts = line.split(" \\| ");  // Split by " | "
                String type = parts[0];  // Task type (T, D, E)
                boolean isDone = parts[1].equals("1");  // Task status (1 = done, 0 = not done)
                String description = parts[2];  // Task description

                // Parse based on task type
                switch (type) {
                    case "T" -> {
                        Todo todo = new Todo(description);
                        if (isDone) todo.markAsDone();
                        tasks.add(todo);
                    }
                    case "D" -> {
                        String by = parts[3];  // Due date for the deadline
                        Deadline deadline = new Deadline(description, by);
                        if (isDone) deadline.markAsDone();
                        tasks.add(deadline);
                    }
                    case "E" -> {
                        String from = parts[3];  // Start time for the event
                        String to = parts.length > 4 ? parts[4] : "";  // End time for the event
                        Event event = new Event(description, from, to);
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
                writer.write(taskToFileString(task));  // Convert task to file format
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ ERROR: Unable to save tasks to file.");
        }
    }

    // Convert task to file string format
    private static String taskToFileString(Task task) {
        String status = task.isDone() ? "1" : "0";  // Convert task status to 1/0
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");

        if (task instanceof Todo) {
            return String.format("T | %s | %s", status, task.getDescription());
        }

        if (task instanceof Deadline deadline) {
            String deadlineFormatted = deadline.getBy().format(formatter);
            return String.format("D | %s | %s | %s", status, task.getDescription(), deadlineFormatted);
        }

        if (task instanceof Event event) {
            String fromFormatted = event.getFrom().format(formatter);  // Use getter here
            String toFormatted = event.getTo().format(formatter);      // Use getter here
            return String.format("E | %s | %s | %s | %s", status, task.getDescription(), fromFormatted, toFormatted);
        }
        return "";
    }

}