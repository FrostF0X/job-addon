package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.JobAddonContext;

public class Addon {

    private JobAddonContext context;

    public Addon(JobAddonContext context) {
        this.context = context;
    }

    public Addon(AddonContextAction addonAction) {
        this(addonAction.getContext());
    }

    private JobAddonContext getContext() {
        return context;
    }

    @Override
    public boolean equals(Object addon) {
        return addon instanceof Addon && context.equals(((Addon) addon).getContext());
    }
}
