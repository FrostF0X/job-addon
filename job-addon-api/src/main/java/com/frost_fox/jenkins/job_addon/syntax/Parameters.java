package com.frost_fox.jenkins.job_addon.syntax;

import hudson.model.Item;
import hudson.model.Job;
import jenkins.model.Jenkins;

public class Parameters {

    private final String name;
    private final Job job;

    public Parameters(String name, String jobId) {
        checkParameter(name, "name");
        checkParameter(jobId, "jobId");
        this.name = name;
        this.job = getJob(jobId);
    }

    private Job getJob(String jobId) {
        Jenkins jenkins = Jenkins.getInstance();
        if (jenkins == null) {
            throw new RuntimeException("jenkins not found o_O (Jenkins.getInstance() returned null)");
        }
        Item item = jenkins.getItem(jobId);
        if (!(item instanceof Job)) {
            throw new RuntimeException("Job with such ID does not exists");
        }
        return (Job) item;
    }

    private void checkParameter(String parameter, String name) {
        if (parameter == null || parameter.isEmpty()) {
            throw new IllegalArgumentException("must specify " + name);
        }
    }

    public String getName() {
        return name;
    }

    public Job getJob() {
        return job;
    }
}
