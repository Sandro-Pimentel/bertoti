import java.util.Comparator;
import java.util.List;

class DeadlineSort implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDeadline));
    }
}