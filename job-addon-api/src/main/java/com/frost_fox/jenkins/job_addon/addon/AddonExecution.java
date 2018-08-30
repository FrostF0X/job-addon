package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Objects;

public class AddonExecution {
    private final Addon addon;

    public AddonExecution(AddonContext context) {
        addon = new Addon(context);
    }

    public Addon getAddon() {
        return addon;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AddonExecution && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addon);
    }
}
