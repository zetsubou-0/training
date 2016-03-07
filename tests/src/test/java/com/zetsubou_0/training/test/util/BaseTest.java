package com.zetsubou_0.training.test.util;

public class BaseTest<T> {

    protected T sut;

    protected void setupClass(final Class<? extends T> testClass)
            throws IllegalAccessException, InstantiationException {
        sut = testClass.newInstance();
    }
}
