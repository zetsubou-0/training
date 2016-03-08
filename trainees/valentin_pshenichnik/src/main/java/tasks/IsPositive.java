package tasks;

import com.zetsubou_0.training.task.task001.Task;

/**
 * Created by admin on 08.03.2016.
 */
public class IsPositive  implements Task{
    public boolean isPositive(int number) {
        if (number>=0){
            return true;
        }else{
        return false;}
    }
}
