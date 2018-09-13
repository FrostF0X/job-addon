package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.FakeAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.FakeJenkinsJobRepository;

public class FakeJobDescriptionFactories {

    public static JobDescriptionFactories get() {
        JobDescriptionFactories factories = new JobDescriptionFactories();
        factories.withManager(new FakeAddonExecutionManager())
                .withRepository(new FakeJenkinsJobRepository())
                .withInfoRepository(new FakeBuildInfoRepository());
        return factories;
    }

}
