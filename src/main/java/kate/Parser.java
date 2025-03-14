package kate;

// Importing commands
import command.Command;
import command.AddCommand;
import command.ExitCommand;
import command.ListCommand;
import command.MarkCommand;
import command.UnmarkCommand;
import command.DeleteCommand;
import command.FindCommand;


// Importing tasks
import task.Todo;
import task.Deadline;
import task.Event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The Parser class processes user input and converts it into the corresponding command.
 */
public class Parser {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
    /**
     * Parses a user input string and returns the corresponding Command object.
     *
     * @param input The user input string.
     * @param taskList The current list of tasks.
     * @return The Command object corresponding to the user input.
     * @throws KateException If the input is invalid or unrecognized.
     */
    public static Command parse(String input, TaskList taskList) throws KateException {
        String[] words = input.trim().split(" ", 2);
        String command = words[0];

        return switch (command) {
            case "todo" -> parseTodo(words);
            case "deadline" -> parseDeadline(words);
            case "event" -> parseEvent(words);
            case "list" -> new ListCommand();
            case "mark" -> parseMark(words, taskList);
            case "unmark" -> parseUnmark(words, taskList);
            case "delete" -> parseDelete(words, taskList);
            case "bye" -> new ExitCommand();
            case "find" -> parseFind(words);
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

        String startTime = timeParts[0].trim();
        String endTime = timeParts[1].trim();

        // Validate start and end times
        try {
            LocalDateTime.parse(startTime, DATE_TIME_FORMATTER);
            LocalDateTime.parse(endTime, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new KateException("Invalid date format! Please enter in dd/MM/yyyy HHmm format.");
        }

        return new AddCommand(new Event(eventParts[0], startTime, endTime));
    }

    private static Command parseMark(String[] words, TaskList taskList) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to mark.");
        }

        int taskIndex = Integer.parseInt(words[1]);

        if (taskIndex < 0 || taskIndex >= taskList.getSize() + 1) {
            throw new KateException("Oops! Task number out of range.");
        }

        return new MarkCommand(taskIndex);
    }

    private static Command parseUnmark(String[] words, TaskList taskList) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to unmark.");
        }

        int taskIndex = Integer.parseInt(words[1]);

        if (taskIndex < 0 || taskIndex >= taskList.getSize() + 1) {
            throw new KateException("Oops! Task number out of range.");
        }

        return new UnmarkCommand(taskIndex);
    }


    private static Command parseDelete(String[] words, TaskList taskList) throws KateException {
        if (words.length < 2 || !words[1].matches("\\d+")) {
            throw new KateException("Oops! Please provide a valid task number to delete.");
        }

        int taskIndex = Integer.parseInt(words[1]);

        if (taskIndex < 0 || taskIndex >= taskList.getSize() + 1) {
            throw new KateException("Oops! Task number out of range.");
        }

        return new DeleteCommand(taskIndex);
    }

    private static Command parseFind(String[] words) throws KateException {
        if (words.length < 2) {
            throw new KateException("Please provide a keyword to search for.");
        }
        String keyword = words[1].trim();
        return new FindCommand(keyword);  // Return FindCommand with the keyword
    }


}

