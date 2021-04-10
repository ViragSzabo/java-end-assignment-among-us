class RegularTaskTest_1 {
    public RegularTask regularTask1 = new RegularTask("mop", "water is on the floor", 1);
    public RegularTask regularTask2 = new RegularTask("fix", "cannot register in", 1);

    void getIsDone() {
        assert(regularTask1.getIsDone());
    }

    void getSetDone(){
        assert(regularTask1.getIsDone());
    }

    void getIsUrgent(){
        assert(!regularTask1.getIsUrgent());
        assert(!regularTask2.getIsUrgent());
    }
}