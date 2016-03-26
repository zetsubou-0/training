package com.zetsubou_0.training.test.task004;

import com.zetsubou_0.training.task.task004.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import com.zetsubou_0.training.test.util.TestConstant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskTest extends BaseTest<Task> {

    private static final int[][] EXPECTED_RESULT = {
            {1},
            {1, 2},
            {3, 5, 8},
            {13, 21, 34, 55},
            {89, 144, 233, 377, 610}
    };

    @Test
    public void shouldReturnFifthLevelArray() {
        int[][] result = sut.fibonacciArray(5);
        Assert.assertArrayEquals(TestConstant.Test004.UNEXPECTED_ARRAY, EXPECTED_RESULT, result);
    }

    @Test
    public void shouldReturnNull() {
        int[][] result = sut.fibonacciArray(2);
        Assert.assertNull(result);
    }
}
