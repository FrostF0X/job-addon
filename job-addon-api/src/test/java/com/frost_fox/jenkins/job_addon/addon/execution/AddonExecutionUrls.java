package com.frost_fox.jenkins.job_addon.addon.execution;

public class AddonExecutionUrls {
    private final String URL = "http://test.com/job/";
    private final String BUILD_ID = "build_id";
    private final String ADDON_ID = "addon_id";

    private String jobUrl = URL;
    private String buildId = BUILD_ID;
    private String addonId = ADDON_ID;

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