package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.AddonContext;

import java.util.Objects;

public class Addon {

    private final String name;
    private final String id;

    public Addon(AddonContext context) {
        this.name = context.getName();
        this.id = context.getId();
    }

    public Addon(AddonContextAction addonAction) {
        this(addonAction.getContext());
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object addon) {
        return addon instanceof Addon && addon.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
