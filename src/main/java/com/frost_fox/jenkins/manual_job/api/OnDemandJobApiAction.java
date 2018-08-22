package com.frost_fox.jenkins.manual_job.api;

import hudson.model.Action;

public class OnDemandJobApiAction implements Action {
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
        return "onDemandJob";
    }
}
