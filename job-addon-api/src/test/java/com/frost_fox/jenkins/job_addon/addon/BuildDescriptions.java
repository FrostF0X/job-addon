package com.frost_fox.jenkins.job_addon.addon;

import java.util.Collections;
import java.util.List;

public class BuildDescriptions {
    private static BuildDescription create(List<Addon> addons) {
        return new BuildDescription(addons, "id");
    }

    public static List<BuildDescription> single(List<Addon> addons) {
        return Collections.singletonList(BuildDescriptions.create(addons));
    }
}
