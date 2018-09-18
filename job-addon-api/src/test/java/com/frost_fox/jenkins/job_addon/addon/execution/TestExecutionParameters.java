package com.frost_fox.jenkins.job_addon.addon.execution;

import java.util.HashMap;
import java.util.Map;

public class TestExecutionParameters {

    private static final String KEY = "key1";
    private static final String VALUE = "value1";
    private static final String KEY2 = "key2";
    private static final String VALUE2 = "value2";


    public static ExecutionParameters get() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(KEY, VALUE);
        parameters.put(KEY2, VALUE2);
        return new ExecutionParameters(parameters);
    }

}
