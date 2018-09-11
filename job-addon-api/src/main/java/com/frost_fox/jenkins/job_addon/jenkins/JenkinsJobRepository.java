package com.frost_fox.jenkins.job_addon.jenkins;

import org.jenkinsci.plugins.workflow.job.WorkflowJob;

public interface JenkinsJobRepository {

    long getEstimation(String id) throws NoSuchJob;

    WorkflowJob getJob(String jobId) throws NoSuchJob;
}
