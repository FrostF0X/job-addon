package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

import java.util.List;
import java.util.Objects;

public class JobDescription {

    private List<BuildDescription> buildDescriptions;
    private long estimation;

    public JobDescription(List<BuildDescription> buildDescriptions, long estimation) {
        this.buildDescriptions = buildDescriptions;
        this.estimation = estimation;
    }

    @SuppressWarnings("WeakerAccess")
    public List<BuildDescription> getBuildDescriptions() {
        return buildDescriptions;
    }

    public long getEstimation() {
        return estimation;
    }

    @Override
    public boolean equals(Object description) {
        return description instanceof JobDescription && description.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildDescriptions);
    }

    public AddonExecution getAddonByBuildIdAndJobId(String buildId, String jobId) throws Exception {
        return getBuild(buildId).getAddonById(jobId);
    }

    private BuildDescription getBuild(String buildId) throws NoSuchBuild {
        return this.getBuildDescriptions().stream().filter(build -> build.getId().equals(buildId)).findFirst()
                .orElseThrow(NoSuchBuild::new);
    }
}
