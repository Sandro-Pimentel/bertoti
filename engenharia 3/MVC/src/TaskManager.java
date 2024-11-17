import java.util.ArrayList;
import java.util.List;

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private List<TaskObserver> observers = new ArrayList<>();
    private SortStrategy sortStrategy;

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers("Tarefa adicionada: " + task.getName());
    }

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sortTasks() {
        if (sortStrategy != null) {
            sortStrategy.sort(tasks);
            notifyObservers("Tarefas ordenadas usando " + sortStrategy.getClass().getSimpleName());
        } else {
            System.out.println("Nenhuma estratégia de ordenação definida.");
        }
    }

    public void printTasks() {
        tasks.forEach(System.out::println);
    }

    private void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.update(message);
        }
    }
}