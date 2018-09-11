package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.description.JobDescriptionFactories;
import com.frost_fox.jenkins.job_addon.description.JobDescriptionFactory;
import com.frost_fox.jenkins.job_addon.description.JobDescriptionUseCase;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

public class JobDescriptionApiAction implements UnprotectedRootAction {

    private final JobDescriptionUseCase useCase;
    private final WorkflowJob job;

    public JobDescriptionApiAction(WorkflowJob job) {
        this.job = job;
        this.useCase = new JobDescriptionUseCase(JobDescriptionFactories.get().one());
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
        return useCase.execute(JenkinsJob.from(job));
    }

}