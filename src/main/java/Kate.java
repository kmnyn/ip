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
        String[] tasks = new String[100];
        int taskCount = 0;

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
                // Display the list of tasks
                if (taskCount == 0) {
                    System.out.println("No tasks added yet.");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }
                }
                System.out.println("____________________________________________________________");
            } else {
                // Otherwise, add the input as a new task
                if (taskCount < 100) {
                    tasks[taskCount] = input;  // Store the task in the array
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