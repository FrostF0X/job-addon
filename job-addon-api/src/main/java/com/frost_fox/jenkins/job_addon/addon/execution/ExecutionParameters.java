package com.frost_fox.jenkins.job_addon.addon.execution;

import java.util.Map;

public class ExecutionParameters {

    private Map<String, String> parameters;

    public ExecutionParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }
}
