package com.frost_fox.jenkins.manual_job;

import hudson.model.Action;
import hudson.model.InvisibleAction;

import javax.annotation.CheckForNull;

public class RunContextAction extends InvisibleAction {

    public static RunContextAction empty() {
        return new RunContextAction(new EmptyContext());
    }

    private final Context context;

    public RunContextAction(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
