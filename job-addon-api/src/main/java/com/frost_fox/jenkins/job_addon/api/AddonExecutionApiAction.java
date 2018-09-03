package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.addon.JobDescription;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.QueryParameter;

public class AddonExecutionApiAction implements UnprotectedRootAction {

    private WorkflowJob job;

    public AddonExecutionApiAction(WorkflowJob job) {
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
        return "addon-execution";
    }

    @ServeJson
    public String doIndex(@QueryParameter String jobId, @QueryParameter String buildId) throws Exception {
        JobDescription.from(JenkinsJob.from(job)).getAddonByBuildIdAndJobId(jobId, buildId);
        return "test";
    }
}
