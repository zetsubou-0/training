package com.zetsubou_0.training.test.util;

import org.junit.Before;

public class BaseTest<T> {

    protected T sut;

    @Before
    public void setup() throws InstantiationException, IllegalAccessException {
        init();
    }

    protected void setupClass(final Class<? extends T> testClass)
            throws IllegalAccessException, InstantiationException {
        sut = testClass.newInstance();
    }

    public void init() throws IllegalAccessException, InstantiationException {
        // implement
    }
}
