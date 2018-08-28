package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

import java.util.List;
import java.util.stream.Collectors;

public class JobDescription {

    private List<BuildDescription> buildDescriptions;

    public static JobDescription from(JenkinsJob job) {
        return new JobDescription(job.getBuilds().stream().map(BuildDescription::from).collect(Collectors.toList()));
    }

    public JobDescription(List<BuildDescription> buildDescriptions) {
        this.buildDescriptions = buildDescriptions;
    }

    private List<BuildDescription> getBuildDescriptions() {
        return buildDescriptions;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof JobDescription && ((JobDescription) obj).getBuildDescriptions().equals(buildDescriptions);
    }
}
