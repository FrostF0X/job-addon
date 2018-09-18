package com.frost_fox.jenkins.job_addon.addon.execution;

public interface AddonExecutionManager {
    String startAndGetId(String jobId, ExecutionParameters parameters) throws AddonExecutionException;
}
