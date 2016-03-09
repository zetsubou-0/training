package tasks;

import com.zetsubou_0.training.task.task003.Task;

/**
 * Created by admin on 09.03.2016.
 */
public class PrintSequenceOfNumbers implements Task {
    public void printSequence(int start, int stop) {
        for (int i = start; i <=stop ; i++) {
            System.out.println(i);
        }
    }
}
