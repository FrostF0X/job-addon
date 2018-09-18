package com.frost_fox.jenkins.job_addon.syntax;

import com.frost_fox.jenkins.job_addon.addon.execution.ExecutionParameters;
import hudson.model.Item;
import hudson.model.Job;
import jenkins.model.Jenkins;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Parameters {

    private final String name;
    private final Job job;
    private ExecutionParameters executionParameters;

    public Parameters(String name, String jobId, Map<String, String> executionParameters) {
        checkParameter(name, "name");
        checkParameter(jobId, "jobId");
        this.name = name;
        this.job = getJob(jobId);
        this.executionParameters = validateAndGetExecutionParameters(executionParameters);
    }

    private Job getJob(String jobId) {
        Jenkins jenkins = Jenkins.getInstance();
        if (jenkins == null) {
            throw new RuntimeException("jenkins not found o_O (Jenkins.getInstance() returned null)");
        }
        Item item = jenkins.getItem(jobId);
        if (!(item instanceof Job)) {
            throw new RuntimeException("Job with such ID does not exists");
        }
        return (Job) item;
    }

    public ExecutionParameters getExecutionParameters() {
        return executionParameters;
    }

    private ExecutionParameters validateAndGetExecutionParameters(Map<String, String> executionParameters) {
        Map<String, String> parameters =
                new HashMap<>(Optional.ofNullable(executionParameters).orElse(new HashMap<>()));
        return new ExecutionParameters(parameters.entrySet().stream()
                .filter(item -> item.getKey() != null && !item.getKey().isEmpty())
                .map(this::withNormalizedValues)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    private void checkParameter(String parameter, String name) {
        if (parameter == null || parameter.isEmpty()) {
            throw new IllegalArgumentException("must specify " + name);
        }
    }

    public String getName() {
        return name;
    }

    public Job getJob() {
        return job;
    }

    private AbstractMap.SimpleEntry<String, String> withNormalizedValues(Map.Entry<String, String> e) {
        return new AbstractMap.SimpleEntry<>(e.getKey(), Optional.ofNullable(e.getValue()).orElse(""));
    }
}
