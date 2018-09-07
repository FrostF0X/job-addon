package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.description.FakeAddonExecutionManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.frost_fox.jenkins.job_addon.addon.AddonContexts.contextsForIds;

public class AddonExecutions {

    public static List<AddonExecution> forIds(List<String> ids) {
        return forContexts(contextsForIds(ids));
    }

    public static List<AddonExecution> forContexts(List<AddonContext> contexts) {
        return contexts.stream().map(AddonExecutions::addonWithContext).collect(Collectors.toList());
    }

    public static List<AddonExecution> forContext(AddonContext context) {
        return Arrays.asList(addonWithContext(context), addonWithContext(context), addonWithContext(context));
    }

    private static AddonExecution addonWithContext(AddonContext context) {
        return new AddonExecution(context, new FakeAddonExecutionManager());
    }

}
