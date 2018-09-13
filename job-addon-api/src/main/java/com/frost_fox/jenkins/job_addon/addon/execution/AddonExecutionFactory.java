package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.description.BuildInfo;
import com.frost_fox.jenkins.job_addon.description.BuildInfoRepository;
import com.frost_fox.jenkins.job_addon.description.NoSuchBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;

public class AddonExecutionFactory {

    private AddonExecutionManager executionManager;
    private JenkinsJobRepository repository;
    private BuildInfoRepository infoRepository;

    public AddonExecutionFactory(AddonExecutionManager executionManager,
                                 JenkinsJobRepository repository,
                                 BuildInfoRepository infoRepository) {
        this.executionManager = executionManager;
        this.repository = repository;
        this.infoRepository = infoRepository;
    }

    public AddonExecution create(JenkinsJob job, JenkinsBuild build, AddonContext context) throws NoSuchJob, NoSuchBuild {
        return new AddonExecution(
                context,
                getUrl(job, build, context),
                executionManager,
                getEstimation(context),
                getBuildInfo(context)
        );
    }

    private long getEstimation(AddonContext context) throws NoSuchJob {
        return repository.getEstimation(context.getId());
    }

    private AddonExecutionUrl getUrl(JenkinsJob job, JenkinsBuild build, AddonContext context) {
        return new AddonExecutionUrl(job.getUrl(), build.getId(), context.getId());
    }

    private BuildInfo getBuildInfo(AddonContext context) throws NoSuchJob, NoSuchBuild {
        if (context.getLastRunId().isEmpty()){
            return BuildInfo.common();
        }
        return infoRepository.getByJobAndBuildId(context.getId(), context.getLastRunId());
    }

}
