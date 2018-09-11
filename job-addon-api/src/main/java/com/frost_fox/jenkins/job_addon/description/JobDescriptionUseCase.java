package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.Result;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;

public class JobDescriptionUseCase {
    private JobDescriptionFactory factory;

    public JobDescriptionUseCase(JobDescriptionFactory factory) {
        this.factory = factory;
    }

    public Result<JobDescription> execute(JenkinsJob job) {
        try {
            return Result.successfulWith(factory.create(job));
        } catch (NoSuchJob e) {
            return Result.failedWith(e.getMessage());
        }
    }
}
