package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Objects;

public class Addon {

    private AddonContext context;

    public Addon(AddonContext context) {
        this.context = context;
    }

    public String getName() {
        return context.getName();
    }

    public String getId() {
        return context.getId();
    }

    @Override
    public boolean equals(Object addon) {
        return addon instanceof Addon && addon.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
