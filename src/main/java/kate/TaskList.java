package kate;

import task.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private final List<Task> tasks;

    public TaskList(List<Task> loadedTasks) {
        this.tasks = (loadedTasks != null) ? loadedTasks : new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        Storage.saveTasks(tasks);
    }

    public void deleteTask(int index) throws KateException {
        if (index < 0 || index >= tasks.size()) {
            throw new KateException("Invalid task index.");
        }
        tasks.remove(index);
        Storage.saveTasks(tasks);
    }

    public void markTask(int index) throws KateException {
        if (index < 0 || index >= tasks.size()) {
            throw new KateException("Invalid task index.");
        }
        tasks.get(index).markAsDone();
        Storage.saveTasks(tasks);
    }

    public void unmarkTask(int index) throws KateException {
        if (index < 0 || index >= tasks.size()) {
            throw new KateException("Invalid task index.");
        }
        tasks.get(index).markAsNotDone();
        Storage.saveTasks(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return tasks.size();
    }

    public List<Task> findTasks(String keyword) {
        return tasks.stream()
                .filter(task -> task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}