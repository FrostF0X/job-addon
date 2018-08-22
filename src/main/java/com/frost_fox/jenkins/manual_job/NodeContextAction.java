package com.frost_fox.jenkins.manual_job;

import hudson.model.Action;

import javax.annotation.CheckForNull;

public class NodeContextAction implements Action {

    public static NodeContextAction empty() {
        return new NodeContextAction(new EmptyContext());
    }

    private final Context context;

    public NodeContextAction(Context context) {
        this.context = context;
    }

    @CheckForNull
    @Override
    public String getIconFileName() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return "Context action";
    }

    @Override
    public String getUrlName() {
        return "";
    }

    public Context getContext() {
        return context;
    }
}
