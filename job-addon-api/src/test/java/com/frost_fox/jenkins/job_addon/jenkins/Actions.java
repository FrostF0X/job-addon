package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.AddonContext;
import hudson.model.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actions {
    public static List<Action> arbitraryActions() {
        return Arrays.asList(arbitraryAction(), arbitraryAction(), arbitraryAction());
    }

    private static Action arbitraryAction() {
        return new TestAction();
    }

    public static List<Action> forAddonsContext(AddonContext context) {
        return Arrays.asList(addonContextAction(context), addonContextAction(context), addonContextAction(context));
    }

    private static Action addonContextAction(AddonContext context) {
        return new AddonContextAction(context);
    }

    public static List<Action> mix(List<Action> actions, List<Action> actions1) {
        List<Action> actionsCopy = new ArrayList<>(actions);
        actionsCopy.addAll(actions1);
        return actionsCopy;
    }
}
