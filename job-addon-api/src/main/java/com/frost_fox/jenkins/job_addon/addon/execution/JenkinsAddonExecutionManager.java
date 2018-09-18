package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;
import hudson.model.ParametersAction;
import hudson.model.StringParameterValue;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class JenkinsAddonExecutionManager implements AddonExecutionManager {

    private JenkinsJobRepository repository;

    public JenkinsAddonExecutionManager(JenkinsJobRepository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public String startAndGetId(String jobId, ExecutionParameters parameters) throws AddonExecutionException {
        try {
            WorkflowJob job = repository.getJob(jobId);
            return job.scheduleBuild2(0, createParametersAction(parameters)).waitForStart().getId();
        } catch (NoSuchJob e) {
            throw new AddonExecutionException(e.getMessage());
        } catch (NullPointerException | InterruptedException | ExecutionException e) {
            throw new AddonExecutionException("Unable to wait until job started");
        } catch (Exception e) {
            throw new AddonExecutionException("Something went wrong during execution");
        }
    }

    private ParametersAction createParametersAction(ExecutionParameters parameters) {
        return new ParametersAction(parameters.getParameters().entrySet().stream()
                .map(item -> new StringParameterValue(item.getKey(), item.getValue())).collect(Collectors.toList()));
    }

    private String getParameter(ExecutionParameters parameters, String name) {
        return parameters.getParameters().getOrDefault(name, "");
    }
}
