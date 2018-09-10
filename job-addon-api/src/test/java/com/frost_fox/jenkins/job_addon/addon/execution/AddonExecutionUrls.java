package com.frost_fox.jenkins.job_addon.addon.execution;

public class AddonExecutionUrls {
    public final String URL = "http://test.com/job/";
    public final String BUILD_ID = "build_id";
    public final String ADDON_ID = "addon_id";

    private String jobUrl;
    private String buildId;
    private String addonId;

    public static AddonExecutionUrls get() {
        return new AddonExecutionUrls();
    }

    public AddonExecutionUrls withJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
        return this;
    }

    public AddonExecutionUrls withBuildId(String buildId) {
        this.buildId = buildId;
        return this;
    }

    public AddonExecutionUrls withAddonId(String addonId) {
        this.addonId = addonId;
        return this;
    }

    public AddonExecutionUrl one() {
        return new AddonExecutionUrl(jobUrl, buildId, addonId);
    }
}