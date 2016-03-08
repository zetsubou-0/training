package com.zetsubou_0.training.test.util.synchronizer;

import com.zetsubou_0.training.test.util.synchronizer.api.Synchronizer;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class TestSynchronizer implements Synchronizer, Runnable {

    public static final String TRAINEES_ROOT = "./trainees";
    public static final String TRAINEES_REGEX = "[a-zA-Z]+_[a-zA-Z]+";

    public void synchronize() {
        File traineesRoot = getTraineesRootFile();
        List<String> traineesList = getTraineesList(traineesRoot);
    }

    public void run() {
        synchronize();
    }

    private File getTraineesRootFile() {
        return new File(TRAINEES_ROOT);
    }

    private List<String> getTraineesList(final File traineesRoot) {
        List<String> traineesList = new ArrayList<>();
        File[] directories = traineesRoot.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });
        for (File directory : directories) {
            String name = directory.getName();
            if (name.matches(TRAINEES_REGEX)) {
                traineesList.add(name);
            }
        }
        return traineesList;
    }
}
