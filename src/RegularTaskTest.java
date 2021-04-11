import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularTaskTest {

    @Test
    void setIsDone() {
        RegularTask task1 = new RegularTask("Wet floor", "Mop the floor.", 0.0);
        assertFalse(task1.getIsDone());
        task1.setIsDone();
        assertTrue(task1.getIsDone());
    }

    @Test
    void getIsUrgent() {
        RegularTask task2 = new RegularTask("Register", "Check in.", 0.0);
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);

        assertFalse(task2.getIsUrgent());
        assertTrue(urgent1.getIsUrgent());
    }
}