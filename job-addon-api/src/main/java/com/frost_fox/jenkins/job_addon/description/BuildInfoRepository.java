package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;

public interface BuildInfoRepository {

    BuildInfo getByJobAndBuildId(String jobId, String buildId) throws NoSuchJob, NoSuchBuild;

}
