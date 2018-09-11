package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;

public class AddonExecutionFactory {

    private AddonExecutionManager executionManager;
    private JenkinsJobRepository repository;

    public AddonExecutionFactory(AddonExecutionManager executionManager, JenkinsJobRepository repository) {
        this.executionManager = executionManager;
        this.repository = repository;
    }

    public AddonExecution create(JenkinsJob job, JenkinsBuild build, AddonContext context) throws NoSuchJob {
        return new AddonExecution(
                context, new AddonExecutionUrl(job.getUrl(), build.getId(), context.getId()),
                executionManager, repository.getEstimation(context.getId())
        );
    }

}
