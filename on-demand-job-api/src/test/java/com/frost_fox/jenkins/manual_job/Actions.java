package com.frost_fox.jenkins.manual_job;

import com.frost_fox.jenkins.manual_job.jenkins.TestAction;
import hudson.model.Action;

import java.util.Arrays;
import java.util.List;

public class Actions {
    public static List<Action> arbitraryActions() {
        return Arrays.asList(new Action[]{new TestAction(), new TestAction(), new TestAction()});
    }
}
