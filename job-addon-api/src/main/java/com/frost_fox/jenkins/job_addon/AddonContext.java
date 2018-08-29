package com.frost_fox.jenkins.job_addon;

import java.util.Objects;

public class AddonContext {
    private final String executeUrl;
    private final String name;

    public AddonContext(String executeUrl, String name) {
        this.executeUrl = executeUrl;
        this.name = name;
    }

    public String getExecuteUrl() {
        return executeUrl;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object addonContext) {
        return addonContext instanceof AddonContext && addonContext.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(executeUrl, name);
    }
}
