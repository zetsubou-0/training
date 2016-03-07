package task.task002;

import com.zetsubou_0.training.task.task002.Task;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    private static final String ZERO_VALUE = "Function doesn't return \"zero\" for 0";
    private static final String SHOULD_BE_POSITIVE = "Function doesn't return \"positive\" for positive value";
    private static final String SHOULD_BE_NEGATIVE = "Function doesn't return \"negative\" for negative value";

    private Task sut = new Task();

    @Test
    public void shouldGetPositive() {
        assertEquals(SHOULD_BE_POSITIVE, "positive", sut.condition(123));
    }

    @Test
    public void shouldGetPositiveForZero() {
        assertEquals(ZERO_VALUE, "zero", sut.condition(0));
    }

    @Test
    public void shouldGetNegative() {
        assertEquals(SHOULD_BE_NEGATIVE, "negative", sut.condition(-123));
    }
}
