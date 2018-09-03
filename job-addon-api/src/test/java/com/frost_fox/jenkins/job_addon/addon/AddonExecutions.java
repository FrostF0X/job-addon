package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddonExecutions {

    public static final String ID = "id";

    public static List<AddonExecution> forContexts(List<AddonContext> contexts) {
        return contexts.stream().map(AddonExecutions::addonWithContext).collect(Collectors.toList());
    }

    public static List<AddonExecution> forContext(AddonContext context) {
        return Arrays.asList(addonWithContext(context), addonWithContext(context), addonWithContext(context));
    }

    private static AddonExecution addonWithContext(AddonContext context) {
        return new AddonExecution(context);
    }

    public static AddonContext context() {
        return new AddonContext(ID, "name");
    }

    private static AddonContext contextWithId(String id) {
        return new AddonContext(id, "name");
    }

    public static List<AddonContext> contextsForIds(List<String> ids) {
        return ids.stream().map(AddonExecutions::contextWithId).collect(Collectors.toList());
    }
}
