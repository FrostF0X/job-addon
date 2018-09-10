package com.frost_fox.jenkins.job_addon.addon.execution;

import jenkins.model.Jenkins;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import java.util.concurrent.ExecutionException;

public class JenkinsAddonExecutionManager implements AddonExecutionManager {

    @SuppressWarnings("ConstantConditions")
    @Override
    public String startAndGetId(String jobId) throws AddonExecutionException{
        try {
            WorkflowJob job = (WorkflowJob)Jenkins.getInstance().getItem(jobId);
            return job.scheduleBuild2(0).waitForStart().getId();
        } catch (NullPointerException e){
            throw new AddonExecutionException("Jenkins no present");
        } catch (InterruptedException|ExecutionException e) {
            throw new AddonExecutionException("Unable to wait until job started");
        } catch (ClassCastException e) {
            throw new AddonExecutionException("Only pipeline jobs are available as addons");
        } catch (Exception e) {
            throw new AddonExecutionException("Something went wrong during execution");
        }
    }

}
