package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.addon.AddonRepository;
import com.frost_fox.jenkins.job_addon.addon.XStreamAddonRepository;
import com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecuteUseCase;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.QueryParameter;

public class AddonExecutionApiAction implements UnprotectedRootAction {

    private final AddonRepository repository;
    private final AddonExecuteUseCase executeUseCase;
    private WorkflowJob job;

    public AddonExecutionApiAction(WorkflowJob job) {
        this.job = job;
        repository = new XStreamAddonRepository(job);
        executeUseCase = new AddonExecuteUseCase(repository, JobDescriptionFactory.get());
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
                          @QueryParameter(required = true, value = "build") String buildId) {
        return executeUseCase.execute(jobId, buildId, JenkinsJob.from(job));
    }
}
