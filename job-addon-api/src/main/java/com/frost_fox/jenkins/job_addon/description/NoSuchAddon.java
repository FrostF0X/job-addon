package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.NoSuchEntity;

public class NoSuchAddon extends NoSuchEntity {

    public static final String MESSAGE = "No such addon exists";

    public NoSuchAddon() {
        super(MESSAGE);
    }
}
