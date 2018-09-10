package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

public class AddonExecutionFactory {

    private AddonExecutionManager executionManager;

    public AddonExecutionFactory(AddonExecutionManager executionManager) {
        this.executionManager = executionManager;
    }

    public AddonExecution create(JenkinsJob job, JenkinsBuild build, AddonContext context) {
        return new AddonExecution(
                context, new AddonExecutionUrl(job.getUrl(), build.getId(), context.getId()), executionManager
        );
    }

}
