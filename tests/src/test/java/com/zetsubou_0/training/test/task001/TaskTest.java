package com.zetsubou_0.training.test.task001;

import com.zetsubou_0.training.task.task001.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.zetsubou_0.training.test.util.TestConstant.Test001.*;

public class TaskTest extends BaseTest<Task> {

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
