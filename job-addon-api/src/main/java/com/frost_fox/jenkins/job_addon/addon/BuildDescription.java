package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuildDescription {

    private List<AddonExecution> addonExecutions;
    private String id;

    public BuildDescription(List<AddonExecution> addons, String id) {
        this.addonExecutions = addons;
        this.id = id;
    }

    public static BuildDescription from(JenkinsBuild build) {
        return new BuildDescription(
                build.getAddonActions().stream().map(AddonContextAction::getContext)
                        .map(AddonExecution::new).collect(Collectors.toList()), build.getId()
        );
    }

    public List<AddonExecution> getAddonExecutions() {
        return addonExecutions;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object description) {
        return description instanceof BuildDescription && description.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonExecutions, id);
    }
}
