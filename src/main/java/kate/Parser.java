package kate;

// Importing commands
import command.Command;
import command.AddCommand;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import command.DeleteCommand;


// Importing tasks
import task.Todo;
import task.Deadline;
import task.Event;

/**
 * The Parser class processes user input and converts it into the corresponding command.
 */
public class Parser {

    /**
     * Parses a user input string and returns the corresponding Command object.
     *
     * @param input The user input string.
     * @return The Command object corresponding to the user input.
     * @throws KateException If the input is invalid or unrecognized.
     */
    public static Command parse(String input) throws KateException {
        String[] words = input.trim().split(" ", 2);
        String command = words[0];

        return switch (command) {
            case "todo" -> parseTodo(words);
            case "deadline" -> parseDeadline(words);
            case "event" -> parseEvent(words);
            case "list" -> new ListCommand();
            case "mark" -> parseMark(words);
            case "unmark" -> parseUnmark(words);
            case "delete" -> parseDelete(words);
            case "bye" -> new ExitCommand();
            default ->
                    throw new KateException("Oops! I'm sorry, but I don't recognize that command. Please try again.");
        };
    }

    private static Command parseTodo(String[] words) throws KateException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new KateException("Oops! Please type in a description for the todo.");
        }
        return new AddCommand(new Todo(words[1]));
    }

    private static Command parseDeadline(String[] words) throws KateException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new KateException("Oops! Please type in a description for the deadline.");
        }
        String[] deadlineParts = words[1].split(" /by ", 2);
        if (deadlineParts.length < 2) {
            throw new KateException("Oops! Please include a due date for the deadline.");
        }
        return new AddCommand(new Deadline(deadlineParts[0], deadlineParts[1]));
    }

    private static Command parseEvent(String[] words) throws KateException {
        if (words.length < 2 || words[1].isBlank()) {
            throw new KateException("Oops! Please type in a description for the event.");
        }
        String[] eventParts = words[1].split(" /from ", 2);
        if (eventParts.length < 2) {
            throw new KateException("Oops! Please include a start time for the event.");
        }
        String[] timeParts = eventParts[1].split(" /to ", 2);
        if (timeParts.length < 2) {
            throw new KateException("Oops! Please include an end time for the event.");
        }
        return new AddCommand(new Event(eventParts[0], timeParts[0], timeParts[1]));
    }

    private static Command parseMark(String[] words) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to mark.");
        }
        return new MarkCommand(Integer.parseInt(words[1]));
    }

    private static Command parseUnmark(String[] words) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to unmark.");
        }
        return new UnmarkCommand(Integer.parseInt(words[1]));
    }

    private static Command parseDelete(String[] words) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to delete.");
        }
        // Convert to 1-based index for user-friendliness
        int taskIndex = Integer.parseInt(words[1]);
        return new DeleteCommand(taskIndex);
    }

}

