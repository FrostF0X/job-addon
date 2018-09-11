package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Objects;

public class Addon {

    private AddonContext context;
    private long estimation;

    public Addon(AddonContext context, long estimation) {
        this.context = context;
        this.estimation = estimation;
    }

    public String getName() {
        return context.getName();
    }

    public String getId() {
        return context.getId();
    }

    public long getEstimation() {
        return estimation;
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
