package com.zetsubou_0.training.test.task001;

import com.zetsubou_0.training.task.task001.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest extends BaseTest<Task> {

    private static final String ZERO_VALUE = "Function return false for 0";
    private static final String SHOULD_BE_POSITIVE = "Function return false for positive value";
    private static final String SHOULD_BE_NEGATIVE = "Function return true for negative value";

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
