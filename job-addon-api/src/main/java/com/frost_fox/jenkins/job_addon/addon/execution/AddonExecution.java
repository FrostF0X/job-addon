package com.frost_fox.jenkins.job_addon.addon.execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.Addon;

import java.util.Objects;

public class AddonExecution {
    public final Addon addon;
    private AddonExecutionManager executionManager;
    private AddonContext context;

    public AddonExecution(AddonContext context, AddonExecutionManager executionManager) {
        this.context = context;
        addon = new Addon(context);
        this.executionManager = executionManager;
    }

    public Addon getAddon() {
        return addon;
    }

    public String getLastExecutionId() {
        return this.context.getLastRunId();
    }

    @SuppressWarnings("WeakerAccess")
    public void setLastExecutionId(String id) {
        this.context.setLastRunId(id);
    }

    @JsonIgnore
    public String getId() {
        return getAddon().getId();
    }

    public void start() throws AddonExecutionException {
        this.setLastExecutionId(this.executionManager.startAndGetId(getId()));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AddonExecution && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addon);
    }
}
