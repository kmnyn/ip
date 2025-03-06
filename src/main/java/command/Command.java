package command;

import kate.Ui;
import kate.TaskList;

public interface Command {
    void execute(TaskList taskList, Ui ui);
}
