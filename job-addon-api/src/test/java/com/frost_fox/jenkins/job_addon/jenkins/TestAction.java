package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Action;

public class TestAction implements Action {
    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    @Override
    public String getUrlName() {
        return null;
    }

    @Override
    public boolean equals(Object action) {
        return action instanceof TestAction;
    }
}
