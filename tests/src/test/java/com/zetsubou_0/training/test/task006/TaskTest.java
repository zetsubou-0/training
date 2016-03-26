package com.zetsubou_0.training.test.task006;

import com.zetsubou_0.training.task.task006.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zetsubou_0 on 26.03.16.
 */
public class TaskTest extends BaseTest<Task> {

    private static final int[] ORIGIN_ARRAY = {10, 3, 5, -2, 100, 1, -33, 0};

    private static final int[] ASCENDING_ARRAY = {-33, -2, 0, 1, 3, 5, 10, 100};

    private static final int[] DESCENDING_ARRAY = {100, 10, 5, 3, 1, 0, -2, -33};

    @Test
    public void shouldReturnAscendingSortedArray() {
        int[] result = sut.ascendingSort(ORIGIN_ARRAY);
        Assert.assertArrayEquals(ASCENDING_ARRAY, result);
    }

    @Test
    public void shouldReturnDescendingSortedArray() {
        int[] result = sut.descendingSort(ORIGIN_ARRAY);
        Assert.assertArrayEquals(DESCENDING_ARRAY, result);
    }
}
