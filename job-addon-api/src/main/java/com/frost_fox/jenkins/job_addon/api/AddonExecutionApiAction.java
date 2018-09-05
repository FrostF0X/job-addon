package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.Addon;
import com.frost_fox.jenkins.job_addon.addon.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.JobDescription;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.model.Action;
import hudson.model.Job;
import hudson.model.UnprotectedRootAction;
import jenkins.model.Jenkins;
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
    public Object doIndex(@QueryParameter(required = true, value = "job") String jobId,
                          @QueryParameter(required = true, value = "build") String buildId) throws Exception {
        AddonExecution execution = JobDescription.from(JenkinsJob.from(job)).getAddonByBuildIdAndJobId(buildId, jobId);
        execution.start();
        job.save();
        return null;
    }
}
