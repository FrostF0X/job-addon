package com.frost_fox.jenkins.manual_job.api;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.HttpResponse;
import org.kohsuke.stapler.HttpResponses;

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

    public HttpResponse doIndex() {
        return HttpResponses.plainText(job.getName());
    }

}
