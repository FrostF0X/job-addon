package com.frost_fox.jenkins.job_addon;

import com.frost_fox.jenkins.job_addon.jenkins.TestAction;
import hudson.model.Action;

import java.util.Arrays;
import java.util.List;

public class Actions {
    public static List<Action> arbitraryActions() {
        return Arrays.asList(new Action[]{new TestAction(), new TestAction(), new TestAction()});
    }
}
