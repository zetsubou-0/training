package com.kiryl.lutsyk.task4;

import com.zetsubou_0.training.task.task004.Task;

/**
 * Created by zetsubou_0 on 21.03.16.
 */
public class Fibonacchi implements Task {

    public int[][] fibonacciArray(final int columnsCount) {
        int[][] result = new int[columnsCount][];
        int previous = 1;
        int next = 0;
        for (int i = 0; i < columnsCount; i++) {
            int size = i + 1;
            result[i] = new int[size];
            for (int j = 0; j < size; j++) {
                int sum = previous + next;
                result[i][j] = sum;
                previous = next;
                next = sum;
            }
        }
        return result;
    }
}
