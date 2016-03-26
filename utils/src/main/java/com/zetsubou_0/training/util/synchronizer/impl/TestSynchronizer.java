package com.zetsubou_0.training.util.synchronizer.impl;

import com.zetsubou_0.training.util.synchronizer.api.Synchronizer;
import com.zetsubou_0.training.util.synchronizer.bean.Credentials;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class TestSynchronizer implements Synchronizer {

    private static final String TEMPLATE_FILE_PATH = "test.template";
    private static final String OUTPUT_FILE_NAME = "Test.java";
    private static final String TRAINEES_ROOT = "trainees";
    private static final String TRAINEES_MAIN_PATH = "src/test/java";
    private static final String TRAINEES_PACAGE = "com/zetsubou_0/training/test/trainees";
    private static final String TASK = "task%03d";
    private static final String TEST_MESSAGE = "Tests for %d task was added";
    private static final String DIRECTORY_PERMISSIONS = "rwxr-x---";
    private static final String TRAINEES_REGEX = "[a-zA-Z]+_[a-zA-Z]+";
    private static final String GIT_DIRECTORY = "./";
    private static final String CONFIGURATION = "[remote \"origin\"]\n"
            + "url = https://github.com/zetsubou-0/training.git\n"
            + "fetch = +refs/heads/*:refs/remotes/origin/*\n";

    private final Credentials credentials;
    private final int testNumber;
    private Git git;

    public TestSynchronizer(final Credentials credentials, final int testNumber)
            throws IOException, ConfigInvalidException {
        this.credentials = credentials;
        this.testNumber = testNumber;
        Repository repository = new FileRepositoryBuilder()
                .setMustExist(true)
                .setWorkTree(new File(GIT_DIRECTORY))
                .findGitDir()
                .setup()
                .build();
        repository.getConfig().fromText(CONFIGURATION);
        git = new Git(repository);
    }

    public void synchronize() throws IOException {
        List<String> traineesList = getTraineesList();
        for(String trainees : traineesList) {
            String path = createTraineesTestPath(testNumber, trainees);
            createJavaTest(testNumber, path);
            try {
                addTestToGit(path);
            } catch (GitAPIException e) {
                // todo: logger
                e.printStackTrace();
            }
        }
    }

    private void addTestToGit(final String path) throws GitAPIException {
        git.pull().call();
        git.add().addFilepattern(path + "/Test.java").call();
        git.commit().setMessage(String.format(TEST_MESSAGE, testNumber)).call();
        CredentialsProvider credentialsProvider =
                new UsernamePasswordCredentialsProvider(credentials.getName(), credentials.getPassword());
        git.push().setCredentialsProvider(credentialsProvider).call();
    }

    private void createJavaTest(final int testNumber, final String path) throws IOException {
        Path filePath = getTemplateFile();
        if (filePath == null) {
            throw new IOException("Error occurs while creating file. Path is null");
        }
        StringBuilder javaCode = new StringBuilder();
        try (Stream<String> stream = Files.lines(filePath)) {
            stream.forEach(str -> javaCode.append(str + "\n"));
        }
        String content = String.format(javaCode.toString(), testNumber, testNumber);
        Files.write(Paths.get(path, OUTPUT_FILE_NAME), content.getBytes(Charset.forName("UTF-8")));
    }

    private String createTraineesTestPath(final int testNumber, final String name) throws IOException {
        Path packagePath = Paths.get(getPackagePath(name, testNumber));
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(DIRECTORY_PERMISSIONS);
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Path dirPath;
        try {
            dirPath = Files.createDirectories(packagePath, attr);
        } catch (FileAlreadyExistsException e) {
            return packagePath.toString();
        }
        return dirPath.toString();
    }

    private String getPackagePath(final String name, final int testNumber) {
        StringBuilder path = new StringBuilder();
        path.append(TRAINEES_ROOT);
        path.append("/");
        path.append(name);
        path.append("/");
        path.append(TRAINEES_MAIN_PATH);
        path.append("/");
        path.append(TRAINEES_PACAGE);
        path.append("/");
        path.append(String.format(TASK, testNumber));
        return path.toString();
    }

    private Path getTemplateFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(TEMPLATE_FILE_PATH);
        if (url == null) {
            return null;
        }
        return FileSystems.getDefault().getPath(url.getFile());
    }

    private List<String> getTraineesList() {
        File traineesRoot = new File(TRAINEES_ROOT);
        List<String> traineesList = new ArrayList<>();
        List<File> directories = Arrays.asList(traineesRoot.listFiles(File::isDirectory));
        directories.forEach(directory -> {
            String name = directory.getName();
            if (name.matches(TRAINEES_REGEX)) {
                traineesList.add(name);
            }
        });
        return traineesList;
    }
}
