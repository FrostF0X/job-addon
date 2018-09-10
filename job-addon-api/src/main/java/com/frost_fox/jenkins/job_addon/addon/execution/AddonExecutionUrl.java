package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.api.AddonExecutionApiAction;

import java.util.Objects;

import static com.frost_fox.jenkins.job_addon.api.AddonExecutionApiAction.BUILD_ID;
import static com.frost_fox.jenkins.job_addon.api.AddonExecutionApiAction.JOB_ID;

public class AddonExecutionUrl {

    private final String jobUrl;
    private final String buildId;
    private final String addonId;

    public AddonExecutionUrl(String jobUrl, String buildId, String addonId) {
        this.jobUrl = jobUrl;
        this.buildId = buildId;
        this.addonId = addonId;
    }

    @SuppressWarnings("WeakerAccess")
    public String getJobUrl() {
        return jobUrl;
    }

    public String getBuildId() {
        return buildId;
    }

    public String getAddonId() {
        return addonId;
    }

    @Override
    public String toString() {
        return getJobUrl() + AddonExecutionApiAction.URL_SEGMENT + "?" + JOB_ID + "=" + addonId +
                "&" + BUILD_ID + "=" + buildId;
    }

    @Override
    public boolean equals(Object executionUrl) {
        return executionUrl instanceof AddonExecutionUrl && executionUrl.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobUrl, buildId, addonId);
    }
}
