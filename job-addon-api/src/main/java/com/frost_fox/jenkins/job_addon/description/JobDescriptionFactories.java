package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionManager;
import com.frost_fox.jenkins.job_addon.addon.execution.JenkinsAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.XStreamJenkinsJobRepository;

public class JobDescriptionFactories {

    private JenkinsJobRepository repository = new XStreamJenkinsJobRepository();
    private AddonExecutionManager manager = null;
    private BuildInfoRepository infoRepository = null;

    public static JobDescriptionFactories get() {
        return new JobDescriptionFactories();
    }

    public JobDescriptionFactories withRepository(JenkinsJobRepository repository) {
        this.repository = repository;
        return this;
    }

    public JobDescriptionFactories withManager(AddonExecutionManager manager) {
        this.manager = manager;
        return this;
    }

    public JobDescriptionFactories withInfoRepository(BuildInfoRepository repository) {
        infoRepository = repository;
        return this;
    }

    public JobDescriptionFactory one() {
        return new JobDescriptionFactory(new AddonExecutionFactory(createManager(), repository, createRepository()));
    }

    private AddonExecutionManager createManager() {
        if (manager == null) {
            return new JenkinsAddonExecutionManager(repository);
        }
        return manager;
    }

    private BuildInfoRepository createRepository() {
        if (infoRepository == null) {
            return new XStreamBuildInfoRepository(new XStreamJenkinsJobRepository());
        }
        return infoRepository;
    }

}
