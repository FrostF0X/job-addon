package com.frost_fox.jenkins.manual_job;

public class JobAddonContext implements Context {
    private final String executeUrl;
    private final String name;

    public JobAddonContext(String executeUrl, String name) {
        this.executeUrl = executeUrl;
        this.name = name;
    }

    public String getExecuteUrl() {
        return executeUrl;
    }

    public String getName() {
        return name;
    }
}
