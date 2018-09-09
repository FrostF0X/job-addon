package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.AddonContextBuilder;
import hudson.model.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContextActionBuilder implements ActionBuilder {

    public static final List<String> IDS = AddonContextBuilder.IDS;
    public static final String ID = AddonContextBuilder.ID;
    public static final String NO_SUCH_ADDON_ID = AddonContextBuilder.NO_SUCH_ADDON_ID;

    private AddonContextBuilder contexts = AddonContextBuilder.get();
    private ActionBuilder additionalActions = null;

    public static ContextActionBuilder get() {
        return new ContextActionBuilder();
    }

    public ContextActionBuilder forContexts(AddonContextBuilder contexts) {
        this.contexts = contexts;
        return this;
    }

    public ActionBuilder and(ActionBuilder actions) {
        additionalActions = actions;
        return this;
    }

    @Override
    public List<Action> create() {
        List<Action> actions = contexts.create().stream().map(AddonContextAction::new)
                .map(action -> (Action) action).collect(Collectors.toList());
        actions.addAll(getAdditionalActions());
        return actions;
    }

    private List<Action> getAdditionalActions() {
        if(additionalActions == null) {
            return new ArrayList<>();
        }
        return additionalActions.create();
    }

}
