package io.jenkins.plugins.sample;

import hudson.model.Action;

import javax.annotation.CheckForNull;
import java.awt.*;

public class NodeContextAction implements Action {

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
