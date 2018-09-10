package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.JenkinsAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

import java.util.List;
import java.util.stream.Collectors;

public class JobDescriptionFactory {

    private AddonExecutionFactory executionFactory;

    public JobDescriptionFactory(AddonExecutionFactory executionFactory) {
        this.executionFactory = executionFactory;
    }

    public static JobDescriptionFactory get() {
        return new JobDescriptionFactory(new AddonExecutionFactory(new JenkinsAddonExecutionManager()));
    }

    public JobDescription create(JenkinsJob job) {
        return new JobDescription(job.getBuilds().stream().map(build -> createDescription(job, build))
                .collect(Collectors.toList()));
    }

    private BuildDescription createDescription(JenkinsJob job, JenkinsBuild build) {
        List<AddonExecution> executions = build.getAddonActions().stream().map(AddonContextAction::getContext)
                .map(context -> executionFactory.create(job, build, context)).collect(Collectors.toList());
        return new BuildDescription(executions, build.getId());
    }

}
