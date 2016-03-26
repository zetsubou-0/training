package com.zetsubou_0.training.test.task005;

import com.zetsubou_0.training.task.task005.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import com.zetsubou_0.training.test.util.TestConstant;
import org.junit.Assert;
import org.junit.Test;

public class TaskTest extends BaseTest<Task> {

    private static final int[] PERCENTS = {0, 100, 5, 13, 77};
    private static final double[] RESULT = {0, 1, 0.05, 0.13, 0.77};

    @Test
    public void shouldConvertPercents() {
        double[] portion = sut.portion(PERCENTS);
        Assert.assertArrayEquals(TestConstant.Test005.UNEXPECTED_ARRAY, RESULT, portion, 0.01);
    }
}
