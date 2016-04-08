package tasks.task5;

import com.zetsubou_0.training.task.task005.Task;

/**
 * Created by admin on 08.04.2016.
 */
public class Persent implements Task {
    public double[] portion(int[] percent) {
        double doublePersent[] = new double[percent.length];
        for (int i = 0; i <percent.length ; i++) {
            doublePersent[i]=(double)percent[i]*0.01;
        }
        return doublePersent;
    }
}
