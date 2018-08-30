package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Arrays;
import java.util.List;

public class AddonExecutions {

    public static List<AddonExecution> forContext(AddonContext context) {
        return Arrays.asList(addonWithContext(context), addonWithContext(context), addonWithContext(context));
    }

    private static AddonExecution addonWithContext(AddonContext context) {
        return new AddonExecution(context);
    }

    public static AddonContext context() {
        return new AddonContext("id", "name");
    }

}
