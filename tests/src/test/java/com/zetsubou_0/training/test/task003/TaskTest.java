package com.zetsubou_0.training.test.task003;

import com.zetsubou_0.training.task.task003.Task;
import com.zetsubou_0.training.test.util.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TaskTest extends BaseTest<Task> {

    private PrintStream out = mock(PrintStream.class);

    @Before
    public void setup() throws InstantiationException, IllegalAccessException {
        init();
        System.setOut(out);
    }

    @After
    public void clean() {
        System.setOut(null);
    }

    @Test
    public void shouldPrintSequence() {
        sut.printSequence(-2, 2);

        verify(out).println(-2);
        verify(out).println(-1);
        verify(out).println(0);
        verify(out).println(1);
        verify(out).println(2);
    }
}
