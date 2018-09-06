package com.frost_fox.jenkins.job_addon.addon.execution;

public class FakeAddonExecutionManager implements AddonExecutionManager {
    @Override
    public String startAndGetId(String jobId) {
        return "id";
    }
}
