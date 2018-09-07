package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.AddonContextAction;
import hudson.model.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Actions {
    public static List<Action> arbitraryActions() {
        return Arrays.asList(arbitraryAction(), arbitraryAction(), arbitraryAction());
    }

    private static Action arbitraryAction() {
        return new TestAction();
    }

    public static List<Action> forAddonContext(AddonContext context) {
        return Arrays.asList(addonContextAction(context), addonContextAction(context), addonContextAction(context));
    }

    public static List<Action> withContexts(List<AddonContext> context) {
        return context.stream().map(Actions::addonContextAction).collect(Collectors.toList());
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
