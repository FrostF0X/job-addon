package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildDescriptions {
    private static BuildDescription create(List<AddonExecution> addons) {
        return new BuildDescription(addons, "id");
    }

    public static List<BuildDescription> single(List<AddonExecution> addons) {
        return Collections.singletonList(singleOne(addons));
    }

    public static BuildDescription singleOne(List<AddonExecution> addons) {
        return BuildDescriptions.create(addons);
    }

    public static List<BuildDescription> manyWithIds(List<String> ids, List<AddonExecution> addons) {
        return ids.stream().map(id -> new BuildDescription(addons, id)).collect(Collectors.toList());
    }
}
