import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CompositeTask extends Task {
    private List<Task> subtasks = new ArrayList<>();

    public CompositeTask(String name, int priority, Date deadline) {
        super(name, priority, deadline);
    }

    public void addSubtask(Task task) {
        subtasks.add(task);
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    @Override
    public String toString() {
        return super.toString() + " com " + subtasks.size() + " subtarefa(s)";
    }
}