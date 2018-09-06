package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionManager;
import com.frost_fox.jenkins.job_addon.addon.execution.JenkinsAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

import java.util.List;
import java.util.stream.Collectors;

public class JobDescriptionFactory {

    private AddonExecutionManager executionManager;

    public JobDescriptionFactory(AddonExecutionManager executionManager) {
        this.executionManager = executionManager;
    }

    public static JobDescriptionFactory get(){
        return new JobDescriptionFactory(new JenkinsAddonExecutionManager());
    }

    public JobDescription create(JenkinsJob job) {
        return new JobDescription(job.getBuilds().stream().map(this::createDescription).collect(Collectors.toList()));
    }

    private BuildDescription createDescription(JenkinsBuild build) {
        List<AddonExecution> executions = build.getAddonActions().stream().map(AddonContextAction::getContext)
                .map(this::createExecution).collect(Collectors.toList());
        return new BuildDescription(executions, build.getId());
    }

    private AddonExecution createExecution(AddonContext context) {
        return new AddonExecution(context, executionManager);
    }

}
