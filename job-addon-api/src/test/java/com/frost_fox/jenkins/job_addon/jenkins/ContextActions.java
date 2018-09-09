package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import hudson.model.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContextActions implements Actions {

    public static final List<String> IDS = AddonContexts.IDS;
    public static final String ID = AddonContexts.ID;
    public static final String NO_SUCH_ADDON_ID = AddonContexts.NO_SUCH_ADDON_ID;

    private AddonContexts contexts = AddonContexts.get();
    private Actions additionalActions = null;

    public static ContextActions get() {
        return new ContextActions();
    }

    public ContextActions forContexts(AddonContexts contexts) {
        this.contexts = contexts;
        return this;
    }

    public Actions and(Actions actions) {
        additionalActions = actions;
        return this;
    }

    @Override
    public List<Action> all() {
        List<Action> actions = contexts.all().stream().map(AddonContextAction::new)
                .map(action -> (Action) action).collect(Collectors.toList());
        actions.addAll(getAdditionalActions());
        return actions;
    }

    private List<Action> getAdditionalActions() {
        if(additionalActions == null) {
            return new ArrayList<>();
        }
        return additionalActions.all();
    }

}
