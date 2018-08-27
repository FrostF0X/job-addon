package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.Context;

public class SomeContext implements Context {

    private final String name = "some context name";

    public String getName() {
        return name;
    }
}
