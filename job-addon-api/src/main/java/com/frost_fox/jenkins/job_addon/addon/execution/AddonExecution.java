package com.frost_fox.jenkins.job_addon.addon.execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.Addon;

import java.util.Objects;

public class AddonExecution {
    public final Addon addon;
    private AddonExecutionUrl url;
    private AddonExecutionManager executionManager;
    private AddonContext context;

    public AddonExecution(AddonContext context, AddonExecutionUrl url, AddonExecutionManager executionManager,
                          long estimation) {
        this.context = context;
        this.url = url;
        this.executionManager = executionManager;
        addon = new Addon(context, estimation);
    }

    public Addon getAddon() {
        return addon;
    }

    public String getLastExecutionId() {
        return this.context.getLastRunId();
    }

    @JsonIgnore
    public AddonExecutionUrl getUrl() {
        return url;
    }

    @JsonProperty("url")
    public String getUrlString() {
        return url.toString();
    }

    @JsonIgnore
    public String getId() {
        return getAddon().getId();
    }

    @SuppressWarnings("WeakerAccess")
    public void setLastExecutionId(String id) {
        this.context.setLastRunId(id);
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
