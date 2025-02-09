import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kate {
    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    private static final Logger logger = Logger.getLogger(Kate.class.getName());

    public static void main(String[] args) {
        // Greet the user
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kate");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        Scanner scanner = null;

        try {
            File inputFile = new File("input.txt");

            if (inputFile.exists()) {
                // Use file input if input.txt exists
                scanner = new Scanner(inputFile);
            } else {
                // If file not found, fall back to console input
                System.out.println("input.txt not found, using console input.");
                scanner = new Scanner(System.in);
            }

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                // If the input is "bye", break out of the loop and exit
                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("____________________________________________________________");
                    System.out.println("Bye. See ya!");
                    System.out.println("____________________________________________________________");
                    break;  // Exit the program
                } else if (input.equals("list")) {
                    listTasks();
                } else if (input.startsWith("todo ")) {
                    addTodo(input.substring(5));
                } else if (input.startsWith("deadline ")) {
                    String[] parts = input.substring(9).split(" /by ");
                    addDeadline(parts[0], parts[1]);
                } else if (input.startsWith("event ")) {
                    String[] parts = input.substring(6).split(" /from | /to ");
                    addEvent(parts[0], parts[1], parts[2]);
                } else if (input.startsWith("mark ")) {
                    markTask(Integer.parseInt(input.substring(5)) - 1);
                } else if (input.startsWith("unmark ")) {
                    unmarkTask(Integer.parseInt(input.substring(7)) - 1);
                } else {
                    System.out.println("Unknown command!");
                }
            }

        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "The file 'input.txt' was not found.", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An unexpected error occurred.", e);
        } finally {
            if (scanner != null) {
                scanner.close(); // Always close the scanner when done
            }
        }

    }

    private static void listTasks() {
        if (taskCount == 0) {
            System.out.println("Your task list is empty.");
            return;
        }
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
    }

    private static void addTodo(String description) {
        tasks[taskCount++] = new Todo(description);
        System.out.println("Got it. I've added this task:\n  " + tasks[taskCount - 1]);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    private static void addDeadline(String description, String by) {
        tasks[taskCount++] = new Deadline(description, by);
        System.out.println("Got it. I've added this task:\n  " + tasks[taskCount - 1]);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    private static void addEvent(String description, String from, String to) {
        tasks[taskCount++] = new Event(description, from, to);
        System.out.println("Got it. I've added this task:\n  " + tasks[taskCount - 1]);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
    }

    private static void markTask(int index) {
        if (index >= 0 && index < taskCount) {
            tasks[index].markAsDone();
            System.out.println("Nice! I've marked this task as done:\n  " + tasks[index]);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void unmarkTask(int index) {
        if (index >= 0 && index < taskCount) {
            tasks[index].markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:\n  " + tasks[index]);
        } else {
            System.out.println("Invalid task number.");
        }
    }
}