import java.util.Scanner;

public class Kate {
    public static void main(String[] args) {
        // Greet the user
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kate");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Create an array to store tasks (fixed size of 100 as per instruction)
        Task[] tasks = new Task[100];
        int taskCount = 0;  // To track how many tasks have been added

        // Start an infinite loop to continuously ask for user input
        while (true) {
            // Read the user's command
            String input = scanner.nextLine();

            // If the input is "bye", break out of the loop and exit
            if (input.equalsIgnoreCase("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. See ya!");
                System.out.println("____________________________________________________________");
                break;  // Exit the program
            }

            // If the input is "list", show all stored tasks
            if (input.equalsIgnoreCase("list")) {
                System.out.println("____________________________________________________________");
                System.out.println("Here are the tasks in your list:");
                // Display the list of tasks
                if (taskCount == 0) {
                    System.out.println("No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + "." + tasks[i].getStatusIcon() + " " + tasks[i].getDescription());
                    }
                }
                System.out.println("____________________________________________________________");
            } else if (input.startsWith("mark")) {
                // Mark a task as done
                try {
                    int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1; // Get the task index
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].markAsDone();
                        System.out.println("____________________________________________________________");
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks[taskIndex].getStatusIcon() + " " + tasks[taskIndex].getDescription());
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("Task not found.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid task number.");
                }
            } else if (input.startsWith("unmark")) {
                // Unmark a task (set it back to not done)
                try {
                    int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1; // Get the task index
                    if (taskIndex >= 0 && taskIndex < taskCount) {
                        tasks[taskIndex].unmark();
                        System.out.println("____________________________________________________________");
                        System.out.println("OK, I've marked this task as not done yet:");
                        System.out.println(tasks[taskIndex].getStatusIcon() + " " + tasks[taskIndex].getDescription());
                        System.out.println("____________________________________________________________");
                    } else {
                        System.out.println("Task not found.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid task number.");
                }
            } else {
                // Otherwise, add the input as a new task
                if (taskCount < 100) {
                    tasks[taskCount] = new Task(input);  // Create a new task and add it
                    taskCount++;  // Increment task count
                    System.out.println("____________________________________________________________");
                    System.out.println("added: " + input);  // Confirm the task has been added
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println("Sorry, you can't add more tasks. Limit reached.");
                    System.out.println("____________________________________________________________");
                }
            }
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
