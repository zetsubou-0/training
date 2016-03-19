package com.zetsubou_0.training.util.synchronizer;

import com.zetsubou_0.training.util.synchronizer.api.Synchronizer;
import com.zetsubou_0.training.util.synchronizer.bean.Credentials;
import com.zetsubou_0.training.util.synchronizer.impl.TestSynchronizer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class SynchronizationJob {

    public static void main(String[] args) {
        if (args.length != 3) {
            return;
        }
        int task = Integer.valueOf(args[0]);
        String name = args[1];
        String password = args[2];
        if (task != 0 && StringUtils.isBlank(name) && StringUtils.isBlank(password)) {
            return;
        }
        Credentials geiCredentials = new Credentials(name, password);
        try {
            Synchronizer synchronizer = new TestSynchronizer(geiCredentials, task);
            synchronizer.synchronize();
        } catch (IOException e) {
            // todo: logger should be added
            e.printStackTrace();
        }
    }
}
