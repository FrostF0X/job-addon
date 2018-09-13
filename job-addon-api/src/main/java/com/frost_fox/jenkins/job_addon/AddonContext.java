package com.frost_fox.jenkins.job_addon;

import java.util.Objects;

public class AddonContext {
    private final String name;
    private final String id;
    private String lastRunId;

    public AddonContext(String id, String name) {
        this(id, name, "");
    }

    public AddonContext(String id, String name, String lastRunId) {
        this.name = name;
        this.id = id;
        this.lastRunId = lastRunId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getLastRunId() {
        return lastRunId;
    }

    public void setLastBuildId(String lastRunId) {
        this.lastRunId = lastRunId;
    }

    @Override
    public boolean equals(Object addonContext) {
        return addonContext instanceof AddonContext && addonContext.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
