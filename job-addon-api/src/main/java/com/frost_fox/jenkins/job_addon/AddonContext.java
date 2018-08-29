package com.frost_fox.jenkins.job_addon;

import java.util.Objects;

public class AddonContext {
    private final String name;
    private final String id;

    public AddonContext(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object addonContext) {
        return addonContext instanceof AddonContext && addonContext.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
