package command;

import kate.Kate;

public class ListCommand implements Command {
    @Override
    public void execute() {
        Kate.listTasks();
    }
}
