package com.frost_fox.jenkins.job_addon;

import hudson.model.InvisibleAction;

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
