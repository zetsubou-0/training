package com.zetsubou_0.training.test.trainees.task001;

import com.zetsubou_0.training.test.task001.TaskTest;
import mypackagename.subpackage.MyClassName;
import org.junit.Before;

public class Test extends TaskTest {

    @Before
    public void setup() throws InstantiationException, IllegalAccessException {
        setupClass(MyClassName.class);
    }
}
