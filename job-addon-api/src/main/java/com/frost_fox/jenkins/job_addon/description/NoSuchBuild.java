package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.NoSuchEntity;

public class NoSuchBuild extends NoSuchEntity {

    public static final String MESSAGE = "No build with such id";

    public NoSuchBuild() {
        super(MESSAGE);
    }
}
