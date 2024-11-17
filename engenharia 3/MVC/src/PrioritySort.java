import java.util.Comparator;
import java.util.List;

class PrioritySort implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getPriority));
    }
}
