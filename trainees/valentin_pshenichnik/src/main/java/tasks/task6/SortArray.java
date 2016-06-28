package tasks.task6;

import com.zetsubou_0.training.task.task006.Task;

import java.util.Arrays;

/**
 * Created by admin on 31.03.2016.
 */
public class SortArray implements Task {
    public int[] ascendingSort(int[] array) {
        Arrays.parallelSort(array);
        return array;
    }

    public int[] descendingSort(int[] array) {
        int[] arrayNew = new int[array.length];
        Arrays.parallelSort(array);
        for (int i = 0; i <array.length ; i++) {
            arrayNew[i] = array[array.length - i];
        }
        return new int[0];
    }
}
