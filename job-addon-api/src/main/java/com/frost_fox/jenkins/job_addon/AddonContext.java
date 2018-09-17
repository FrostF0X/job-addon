package com.frost_fox.jenkins.job_addon;

import java.util.Map;
import java.util.Objects;

public class AddonContext {
    private final String name;
    private final String id;
    private final Map<String, String> executionParameters;
    private String lastRunId;

    public AddonContext(String id, String name, Map<String, String> executionParameters) {
        this(id, name, executionParameters, "");
    }

    public AddonContext(String id, String name, Map<String, String> executionParameters, String lastRunId) {
        this.name = name;
        this.id = id;
        this.executionParameters = executionParameters;
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

    public Map<String, String> getExecutionParameters() {
        return executionParameters;
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
