package com.kiryl.lutsyk.task5;

import com.zetsubou_0.training.task.task005.Task;

public class Percent implements Task {

    public double[] portion(final int[] percent) {
        double[] portion = new double[percent.length];
        for (int index = 0; index < percent.length; index++) {
            portion[index] = percent[index] / 100.0;
        }
        return portion;
    }
}
