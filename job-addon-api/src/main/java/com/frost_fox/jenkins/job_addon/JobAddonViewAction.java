package com.frost_fox.jenkins.job_addon;

import hudson.model.Action;

import javax.annotation.CheckForNull;

public class JobAddonViewAction implements Action {
    @CheckForNull
    @Override
    public String getIconFileName() {
        return null;
    }

    @CheckForNull
    @Override
    public String getDisplayName() {
        return "Manual Stage";
    }

    @CheckForNull
    @Override
    public String getUrlName() {
        return "Manual Stage";
    }
}
