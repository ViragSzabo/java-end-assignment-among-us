public class RegularTask implements Task{
    private String taskName;
    private boolean isDone;
    private String description;

    public RegularTask(String taskName, String description, double progress){
        this.taskName = taskName;
        this.description = description;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean getIsDone() {
        return isDone;
    }

    @Override
    public void setIsDone() {
        isDone = true;
    }

    @Override
    public boolean getIsUrgent() {
        return false;
    }
}
