package com.va.ma.task002;

import com.zetsubou_0.training.task.task002.Task;

/**
 * Created by Irina-miv on 19.07.2016.
 */
public class Condition implements Task {
    @Override
    public String condition(int number) {
        if (number>0){
            return "positive";
        }
        if (number<0) {
            return "negative";
        }
        return "zero";
    }
}
