package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.addon.AddonRepository;
import com.frost_fox.jenkins.job_addon.addon.AddonRepositoryException;
import com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionFactory;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

public class AddonExecuteUseCase {

    private static final String GENERIC_ERROR = "Some generic exception happened (something went wrong)";
    private AddonRepository repository;
    private JobDescriptionFactory descriptionFactory;

    public AddonExecuteUseCase(AddonRepository repository, JobDescriptionFactory descriptionFactory) {
        this.repository = repository;
        this.descriptionFactory = descriptionFactory;
    }

    public String execute(String buildId, String jobId, JenkinsJob job) {
        try {
            AddonExecution execution = descriptionFactory.create(job).getAddonByBuildIdAndJobId(buildId, jobId);
            execution.start();
            repository.save(execution);
            return execution.getLastExecutionId();
        } catch (AddonRepositoryException | AddonExecutionException e) {
            return e.getMessage();
        } catch (Exception e) {
            return GENERIC_ERROR;
        }
    }

}
