package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.JobAddonContext;

import java.util.Arrays;
import java.util.List;

public class Addons {

    public static List<Addon> forContext(JobAddonContext context) {
        return Arrays.asList(addonWithContext(context), addonWithContext(context), addonWithContext(context));
    }

    private static Addon addonWithContext(JobAddonContext context) {
        return new Addon(context);
    }

    public static JobAddonContext context() {
        return new JobAddonContext("url", "name");
    }

}
