package com.zetsubou_0.training.util.synchronizer.bean;

/**
 * Created by zetsubou_0 on 19.3.16.
 */
public class Credentials {
    private final String name;

    private final String password;

    public Credentials(final String name, final String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
