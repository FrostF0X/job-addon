package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

import java.util.List;
import java.util.Objects;

public class BuildDescription {

    private List<AddonExecution> addonExecutions;
    private String id;

    public BuildDescription(List<AddonExecution> addons, String id) {
        this.addonExecutions = addons;
        this.id = id;
    }

    @SuppressWarnings("WeakerAccess")
    public List<AddonExecution> getAddonExecutions() {
        return addonExecutions;
    }

    public String getId() {
        return id;
    }

    public AddonExecution getAddonById(String jobId) throws NoSuchAddon {
        return getAddonExecutions().stream().filter(execution -> execution.getId().equals(jobId)).findFirst()
                .orElseThrow(NoSuchAddon::new);
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
