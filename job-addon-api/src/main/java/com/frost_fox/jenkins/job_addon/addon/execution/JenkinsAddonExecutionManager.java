package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import java.util.concurrent.ExecutionException;

public class JenkinsAddonExecutionManager implements AddonExecutionManager {

    private JenkinsJobRepository repository;

    public JenkinsAddonExecutionManager(JenkinsJobRepository repository) {
        this.repository = repository;
    }

    @Override
    public String startAndGetId(String jobId) throws AddonExecutionException {
        try {
            WorkflowJob job = repository.getJob(jobId);
            return job.scheduleBuild2(0).waitForStart().getId();
        } catch (NoSuchJob e) {
            throw new AddonExecutionException(e.getMessage());
        } catch (NullPointerException | InterruptedException | ExecutionException e) {
            throw new AddonExecutionException("Unable to wait until job started");
        } catch (Exception e) {
            throw new AddonExecutionException("Something went wrong during execution");
        }
    }

}
