package com.frost_fox.jenkins.job_addon;

public class JobAddonContext {
    private final String executeUrl;
    private final String name;

    public JobAddonContext(String executeUrl, String name) {
        this.executeUrl = executeUrl;
        this.name = name;
    }

    private String getExecuteUrl() {
        return executeUrl;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof JobAddonContext &&
                ((JobAddonContext) o).getExecuteUrl().equals(executeUrl) &&
                ((JobAddonContext) o).getName().equals(name);
    }

}
