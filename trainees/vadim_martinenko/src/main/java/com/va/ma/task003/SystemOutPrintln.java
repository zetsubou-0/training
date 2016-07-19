package com.va.ma.task003;

import com.zetsubou_0.training.task.task003.Task;

/**
 * Created by Irina-miv on 19.07.2016.
 */
public class SystemOutPrintln implements Task {
    @Override
    public void printSequence(int start, int stop) {
            for (int i = start; i <= stop; i++) {
                System.out.println (i);
            }
    }
}
