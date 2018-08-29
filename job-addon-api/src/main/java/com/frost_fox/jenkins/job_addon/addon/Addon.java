package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.JobAddonContext;

import java.util.Objects;

public class Addon {

    private final String name;
    private final String url;

    public Addon(JobAddonContext context) {
        this.name = context.getName();
        this.url = context.getExecuteUrl();
    }

    public Addon(AddonContextAction addonAction) {
        this(addonAction.getContext());
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object addon) {
        return addon instanceof Addon && addon.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}
