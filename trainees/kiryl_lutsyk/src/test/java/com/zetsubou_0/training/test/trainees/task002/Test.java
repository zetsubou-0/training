package com.zetsubou_0.training.test.trainees.task002;

import com.kiryl.lutsyk.task1.MyClass;
import com.zetsubou_0.training.test.task002.TaskTest;
import org.junit.Before;

public class Test extends TaskTest {

    @Before
    public void setup() throws InstantiationException, IllegalAccessException {
        setupClass(MyClass.class);
    }
}
