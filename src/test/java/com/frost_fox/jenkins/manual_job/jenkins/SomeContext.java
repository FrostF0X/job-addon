package com.frost_fox.jenkins.manual_job.jenkins;

import com.frost_fox.jenkins.manual_job.Context;

public class SomeContext implements Context {

    private final String name = "some context name";

    public String getName() {
        return name;
    }
}
