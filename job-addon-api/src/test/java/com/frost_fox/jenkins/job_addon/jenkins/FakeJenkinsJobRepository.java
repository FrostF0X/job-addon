package com.frost_fox.jenkins.job_addon.jenkins;

import org.jenkinsci.plugins.workflow.job.WorkflowJob;

public class FakeJenkinsJobRepository implements JenkinsJobRepository {
    @Override
    public long getEstimation(String id) {
        return 0;
    }

    @Override
    public WorkflowJob getJob(String jobId) {
        return null;
    }
}
