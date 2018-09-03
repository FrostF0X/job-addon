package com.frost_fox.jenkins.job_addon.addon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Objects;

public class AddonExecution {
    public final Addon addon;

    public AddonExecution(AddonContext context) {
        addon = new Addon(context);
    }

    public Addon getAddon() {
        return addon;
    }

    @JsonIgnore
    public String getId() {
        return getAddon().getId();
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
