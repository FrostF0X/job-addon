package com.frost_fox.jenkins.job_addon;

import hudson.model.InvisibleAction;

import java.util.Objects;

public class AddonContextAction extends InvisibleAction {

    private final JobAddonContext context;

    public AddonContextAction(JobAddonContext context) {
        this.context = context;
    }

    public JobAddonContext getContext() {
        return context;
    }

    public boolean equals(Object action) {
        return action instanceof AddonContextAction && action.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(context);
    }
}
