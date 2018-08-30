package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.addon.JobDescription;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

public class JobDescriptionApiAction implements UnprotectedRootAction {

    private WorkflowJob job;

    public JobDescriptionApiAction(WorkflowJob job) {
        this.job = job;
    }

    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return "job-addon";
    }

    public String getFullUrl() {
        return job.getUrl() + getUrlName();
    }

    @ServeJson
    public Object doIndex() {
        return JobDescription.from(JenkinsJob.from(job));
    }

}