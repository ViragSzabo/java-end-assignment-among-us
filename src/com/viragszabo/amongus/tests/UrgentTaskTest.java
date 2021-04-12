import com.viragszabo.amongus.map.NoDoorException;
import com.viragszabo.amongus.task.RegularTask;
import com.viragszabo.amongus.task.UrgentTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrgentTaskTest {

    @Test
    void setIsDone() throws NoDoorException {
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);

        assertFalse(urgent1.getIsDone());
        urgent1.setIsDone();
        assertTrue(urgent1.getIsDone());
    }

    @Test
    void getIsUrgent() {
        UrgentTask urgent1 = new UrgentTask("Leaking", "Gas leaking", 0.0);
        RegularTask task3 = new RegularTask("Documentation", "Update the research document.", 0.0);

        assertTrue(urgent1.getIsUrgent());
        assertFalse(task3.getIsUrgent());
    }
}