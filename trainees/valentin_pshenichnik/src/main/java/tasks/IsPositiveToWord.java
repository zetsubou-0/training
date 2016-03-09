package tasks;

import com.zetsubou_0.training.task.task002.Task;

/**
 * Created by admin on 09.03.2016.
 */
public class IsPositiveToWord implements Task {
    public String condition(int number) {
        if (number>0){
            return "positive";
        }else {
            if (number<0){
                return "negative";
            }else {
                return "zero";
            }
        }
    }
}
