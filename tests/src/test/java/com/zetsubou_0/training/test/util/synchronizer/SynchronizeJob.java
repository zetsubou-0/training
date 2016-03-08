package com.zetsubou_0.training.test.util.synchronizer;

public class SynchronizeJob {

    public static void main(String[] args) {
        Runnable synchronizer = new TestSynchronizer();
        new Thread(synchronizer).start();
    }
}
