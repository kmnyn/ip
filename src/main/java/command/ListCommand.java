package command;

import kate.TaskList;
import kate.Ui;

public class ListCommand implements Command {
    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.showTasks(taskList.getTasks());
    }
}
