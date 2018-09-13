package com.frost_fox.jenkins.job_addon.description;

public class FakeBuildInfoRepository implements BuildInfoRepository {
    @Override
    public BuildInfo getByJobAndBuildId(String jobId, String buildId) {
        return BuildInfo.common();
    }
}
