package tasks;

import com.zetsubou_0.training.task.task004.Task;

/**
 * Created by Torus on 20.03.2016.
 */
public class Fibonacci implements Task {
    public int[][] fibonacciArray(int columnsCount) {
        int fibonacci[][] = new int[columnsCount][];
        for (int i = 0; i <columnsCount ; i++) {
            fibonacci[i] = new int[i+1];
        }
        int summaFibonacci;
        int a = 1;
        int b = 1;
        for (int i = 0; i <columnsCount ; i++) {
            for (int j = 0; j <i+1 ; j++) {
                if ((i == 0 && j == 0) || (i == 1 && j == 0)){
                    fibonacci[i][j] = 1;
                }else {
                    summaFibonacci = a + b;
                    a = b;
                    b = summaFibonacci;
                    fibonacci[i][j] = summaFibonacci;
                }
            }
        }
        return fibonacci;
    }
}