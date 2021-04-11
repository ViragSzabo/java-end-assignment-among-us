package com.viragszabo.amongus.task;

public class UrgentTask implements Task{
        private String taskName;
        private boolean isDone;
        private String description;
        // timer to be added,

        public UrgentTask(String taskName, String description, double progress){
            this.taskName = taskName;
            this.description = description;
            this.isDone = false;
            // start timer for disaster: Thread?
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
        // stop timer for disaster
    }

    @Override
    public boolean getIsUrgent(){
            return true;
    }
}
