package com.frost_fox.jenkins.job_addon.api;

import com.cloudbees.workflow.util.ServeJson;
import com.frost_fox.jenkins.job_addon.addon.AddonRepository;
import com.frost_fox.jenkins.job_addon.addon.XStreamAddonRepository;
import com.frost_fox.jenkins.job_addon.description.JobDescriptionFactories;
import com.frost_fox.jenkins.job_addon.description.JobDescriptionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecuteUseCase;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import hudson.model.UnprotectedRootAction;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.kohsuke.stapler.QueryParameter;

public class AddonExecutionApiAction implements UnprotectedRootAction {

    public static final String URL_SEGMENT = "addon-execution";
    public static final String JOB_ID = "job";
    public static final String BUILD_ID = "build";
    private final AddonRepository repository;
    private final AddonExecuteUseCase executeUseCase;
    private WorkflowJob job;

    public AddonExecutionApiAction(WorkflowJob job) {
        this.job = job;
        repository = new XStreamAddonRepository(job);
        executeUseCase = new AddonExecuteUseCase(repository, JobDescriptionFactories.get().one());
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
        return URL_SEGMENT;
    }

    @ServeJson
    public Object doIndex(@QueryParameter(required = true, value = JOB_ID) String jobId,
                          @QueryParameter(required = true, value = BUILD_ID) String buildId) {
        return executeUseCase.execute(buildId, jobId, JenkinsJob.from(job));
    }
}
