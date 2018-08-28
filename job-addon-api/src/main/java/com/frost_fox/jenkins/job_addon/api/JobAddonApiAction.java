package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.addon.JobDescription;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

@Extension
public class JobAddonApiAction implements UnprotectedRootAction {

    private WorkflowJob job;


    public JobAddonApiAction() {
    }

    public JobAddonApiAction(WorkflowJob job) {
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

    @ServeJson
    public Object doIndex() {
        return JobDescription.from(JenkinsJob.from(job));
    }

}
