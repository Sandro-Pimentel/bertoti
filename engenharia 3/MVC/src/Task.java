import java.util.Date;

class Task {
    private String name;
    private int priority;
    private Date deadline;

    public Task(String name, int priority, Date deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return name + " (Prioridade: " + priority + ", Prazo: " + deadline + ")";
    }
}