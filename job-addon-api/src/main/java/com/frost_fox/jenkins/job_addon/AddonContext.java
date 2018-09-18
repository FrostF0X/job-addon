package com.frost_fox.jenkins.job_addon;

import com.frost_fox.jenkins.job_addon.addon.execution.ExecutionParameters;

import java.util.Objects;

public class AddonContext {
    private final String name;
    private final String id;
    private final ExecutionParameters executionParameters;
    private String lastRunId;

    public AddonContext(String id, String name, ExecutionParameters executionParameters) {
        this(id, name, executionParameters, "");
    }

    public AddonContext(String id, String name, ExecutionParameters executionParameters, String lastRunId) {
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

    public ExecutionParameters getExecutionParameters() {
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
