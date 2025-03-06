package command;

import kate.TaskList;
import kate.Ui;

public class FindCommand implements Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        // Find tasks that match the keyword
        var matchingTasks = taskList.findTasks(keyword);

        if (matchingTasks.isEmpty()) {
            ui.showError("No tasks found matching the keyword: " + keyword);
        } else {
            // Directly pass the matching tasks to the UI
            ui.showTasks(matchingTasks);
        }
    }
}
