package com.frost_fox.jenkins.job_addon;

import hudson.model.InvisibleAction;

public class AddonContextAction extends InvisibleAction {

    private final JobAddonContext context;

    public AddonContextAction(JobAddonContext context) {
        this.context = context;
    }

    public JobAddonContext getContext() {
        return context;
    }

    public boolean equals(Object action) {
        return action instanceof AddonContextAction && ((AddonContextAction) action).getContext().equals(context);
    }
}
