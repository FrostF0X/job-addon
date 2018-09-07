package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildDescriptions {
    private static BuildDescription create(List<AddonExecution> addons) {
        return new BuildDescription(addons, Ids.ID);
    }

    public static List<BuildDescription> single(String id, List<AddonExecution> addons){
        return manyWithIds(Collections.singletonList(id), addons);
    }

    public static BuildDescription singleOne(String id, List<AddonExecution> addons){
        return manyWithIds(Collections.singletonList(id), addons).get(0);
    }

    public static List<BuildDescription> singleWithAddons(List<AddonExecution> addons) {
        return Collections.singletonList(singleOneWithAddons(addons));
    }

    public static BuildDescription singleOneWithAddons(List<AddonExecution> addons) {
        return BuildDescriptions.create(addons);
    }

    public static List<BuildDescription> manyWithIds(List<String> ids, List<AddonExecution> addons) {
        return ids.stream().map(id -> new BuildDescription(addons, id)).collect(Collectors.toList());
    }
}
