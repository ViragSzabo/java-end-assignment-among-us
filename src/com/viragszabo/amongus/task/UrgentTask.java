package com.viragszabo.amongus.task;

public class UrgentTask implements Task{
        private String taskName;
        private boolean isDone;
        private String description;
        private double progress;

        public UrgentTask(String taskName, String description, double progress){
            this.taskName = taskName;
            this.description = description;
            this.isDone = false;
            this.progress = progress;
        }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public double getProgress() { return progress; }

    @Override
    public boolean getIsDone() {
        return isDone;
    }

    @Override
    public void setIsDone() {
        isDone = true;
    }

    public void setProgress(double progress) {  this.progress = progress; }

    @Override
    public boolean getIsUrgent(){
            return true;
    }
}
