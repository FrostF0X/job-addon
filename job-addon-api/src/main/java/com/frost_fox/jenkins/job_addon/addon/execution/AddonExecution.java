package com.frost_fox.jenkins.job_addon.addon.execution;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.Addon;
import com.frost_fox.jenkins.job_addon.description.BuildInfo;

import java.util.Objects;

public class AddonExecution {
    public final Addon addon;
    private AddonExecutionUrl url;
    private AddonExecutionManager executionManager;
    private AddonContext context;
    private BuildInfo lastBuildInfo;

    public AddonExecution(AddonContext context, AddonExecutionUrl url, AddonExecutionManager executionManager,
                          long estimation, BuildInfo buildInfo) {
        this.context = context;
        this.url = url;
        this.executionManager = executionManager;
        this.lastBuildInfo = buildInfo;
        addon = new Addon(context, estimation);
    }

    public Addon getAddon() {
        return addon;
    }

    public BuildInfo getLastBuildInfo() {
        return lastBuildInfo;
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

    public String start() throws AddonExecutionException {
        String lastBuildId = this.executionManager.startAndGetId(getId(), context.getExecutionParameters());
        this.context.setLastBuildId(lastBuildId);
        return lastBuildId;
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
