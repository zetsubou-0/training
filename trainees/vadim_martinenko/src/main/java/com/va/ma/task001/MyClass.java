package com.va.ma.task001;


import com.zetsubou_0.training.task.task001.Task;

/**111
 * Created by User on 25.03.2016.
 */
public class MyClass implements Task{


    public boolean isPositive(int number) {
        if (number>=0) {
            return true;
        }
        return false;
    }
}
