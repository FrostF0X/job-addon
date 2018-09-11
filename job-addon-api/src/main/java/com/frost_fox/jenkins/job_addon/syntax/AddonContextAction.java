package com.frost_fox.jenkins.job_addon.syntax;

import com.frost_fox.jenkins.job_addon.AddonContext;
import hudson.model.InvisibleAction;

import java.util.Objects;

public class AddonContextAction extends InvisibleAction {

    private final AddonContext context;

    public AddonContextAction(AddonContext context) {
        this.context = context;
    }

    public AddonContext getContext() {
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
