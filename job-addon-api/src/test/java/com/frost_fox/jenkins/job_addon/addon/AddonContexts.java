package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddonContexts {

    private static final String ID = "id";

    public static AddonContext context() {
        return new AddonContext(ID, "name");
    }

    public static List<AddonContext> contexts() {
        return Arrays.asList(context(), context(), context());
    }

    private static AddonContext contextWithId(String id) {
        return new AddonContext(id, "name");
    }

    public static List<AddonContext> contextsForIds(List<String> ids) {
        return ids.stream().map(AddonContexts::contextWithId).collect(Collectors.toList());
    }
}
