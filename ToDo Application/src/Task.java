public class Task {
    private String task;
    private int priority;

    public Task(int priority, String task) {
        this.priority = priority;
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "Task: " + task + " (Priority: " + priority + ")";
    }
}
