package task.task001;

import com.zetsubou_0.training.task.task001.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    private static final String ZERO_VALUE = "Function return false for 0";
    private static final String SHOULD_BE_POSITIVE = "Function return false for positive value";
    private static final String SHOULD_BE_NEGATIVE = "Function return true for negative value";

    private Task sut = new Task();

    @Test
    public void shouldGetPositive() {
        assertTrue(SHOULD_BE_POSITIVE, sut.isPositive(123));
    }

    @Test
    public void shouldGetPositiveForZero() {
        assertTrue(ZERO_VALUE, sut.isPositive(0));
    }

    @Test
    public void shouldGetNegative() {
        assertFalse(SHOULD_BE_NEGATIVE, sut.isPositive(-123));
    }
}
