package com.zetsubou_0.training.test.trainees.task004;

import com.zetsubou_0.training.test.task004.TaskTest;
import tasks.Fibonacci;

public class Test extends TaskTest {

    @Override
    public void init() throws IllegalAccessException, InstantiationException {
        setupClass(Fibonacci.class);
    }
}
