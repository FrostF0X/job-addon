package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.NoSuchEntity;

public class NoSuchJob extends NoSuchEntity {
    public NoSuchJob(String id) {
        super("Can't find such job with id " + id);
    }
}
