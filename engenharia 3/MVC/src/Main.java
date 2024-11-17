import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        ConsoleObserver observer = new ConsoleObserver();
        taskManager.addObserver(observer);

        Task task1 = new Task("Tarefa 1", 2, new Date(System.currentTimeMillis() + 86400000)); // Prazo: Amanhã
        Task task2 = new Task("Tarefa 2", 1, new Date(System.currentTimeMillis() + 43200000)); // Prazo: Hoje

        CompositeTask task3 = new CompositeTask("Tarefa 3", 3, new Date(System.currentTimeMillis() + 172800000)); // Prazo: Depois de amanhã
        task3.addSubtask(new Task("Subtarefa 3.1", 2, new Date(System.currentTimeMillis() + 3600000))); // Prazo: 1 hora

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println("\n--- Ordenação por prioridade ---");
        taskManager.setSortStrategy(new PrioritySort());
        taskManager.sortTasks();
        taskManager.printTasks();

        System.out.println("\n--- Ordenação por prazo ---");
        taskManager.setSortStrategy(new DeadlineSort());
        taskManager.sortTasks();
        taskManager.printTasks();
    }
}