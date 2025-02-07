import java.util.Scanner;

public class Kate {
    private static final int MAX_TASKS = 100;
    private static final Task[] tasks = new Task[MAX_TASKS];
    private static int taskCount = 0;

    public static void main(String[] args) {
        // Greet the user
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kate");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

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

        scanner.close();
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

// Following the coding standard