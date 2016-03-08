package com.zetsubou_0.training.test.task002;

import com.zetsubou_0.training.task.task002.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static com.zetsubou_0.training.test.util.TestConstant.Test002.*;

public class TaskTest extends BaseTest<Task> {

    @Before
    public void setup() throws InstantiationException, IllegalAccessException {
        init();
    }

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
