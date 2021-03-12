public class UrgentTaskTest {
    public UrgentTask urgentTask1 = new UrgentTask("repair", "fix the oxygen machine", 1);
    public UrgentTask urgentTask2 = new UrgentTask("fix", "fix the lights", 0);

    void getIsDone() {
        assert(urgentTask1.getIsDone());
    }

    void getSetDone(){
        assert(urgentTask1.getIsDone());
    }

    void getIsUrgent(){
        assert(urgentTask1.getIsUrgent());
        assert(urgentTask2.getIsUrgent());
    }
}
