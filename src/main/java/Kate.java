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

            // Otherwise, echo the user's command
            System.out.println("____________________________________________________________");
            System.out.println(input);  // Echo the command
            System.out.println("____________________________________________________________");
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}