package com.viragszabo.amongus.task;

public class UrgentTask implements Task{
        private String taskName;
        private boolean isDone;
        private String description;
        private double progress;
        private double urgentTaskTimer;

        public UrgentTask(String taskName, String description, double progress, double urgentTaskTimer){
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

    public double getUrgentTaskTimer() { return urgentTaskTimer; }

    public double getProgress() { return progress; }

    @Override
    public boolean getIsDone() {
        return isDone;
    }

    @Override
    public void setIsDone() { isDone = true; }

    public void setProgress(double progress) {  this.progress = progress; }

    @Override
    public boolean getIsUrgent(){
            return true;
    }
}
