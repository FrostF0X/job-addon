package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BuildDescription {

    private List<Addon> addons;
    private String id;

    public static BuildDescription from(JenkinsBuild build) {
        return new BuildDescription(
                build.getAddonActions().stream().map(Addon::new).collect(Collectors.toList()), build.getId()
        );
    }

    public BuildDescription(List<Addon> addons, String id) {
        this.addons = addons;
        this.id = id;
    }

    public List<Addon> getAddons() {
        return addons;
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
        return Objects.hash(addons, id);
    }
}
