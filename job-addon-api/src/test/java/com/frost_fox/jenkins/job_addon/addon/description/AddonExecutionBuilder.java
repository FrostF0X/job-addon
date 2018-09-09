package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.AddonContextBuilder;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

import java.util.List;
import java.util.stream.Collectors;

public class AddonExecutionBuilder {

    public static final String NAME = AddonContextBuilder.NAME;
    public static final List<String> IDS = AddonContextBuilder.IDS;
    public static final String ID = AddonContextBuilder.ID;
    public static final String NO_SUCH_ADDON_ID = AddonContextBuilder.NO_SUCH_ADDON_ID;

    private AddonContextBuilder contexts = AddonContextBuilder.get();
    private FakeAddonExecutionManager executionManager = new FakeAddonExecutionManager();

    public static AddonExecutionBuilder get() {
        return new AddonExecutionBuilder();
    }

    public AddonExecutionBuilder forContexts(AddonContextBuilder contexts) {
        this.contexts = contexts;
        return this;
    }

    public List<AddonExecution> create() {
        return this.contexts.create().stream().map(this::createAddonExecution).collect(Collectors.toList());
    }

    private AddonExecution createAddonExecution(AddonContext context) {
        return new AddonExecution(context, executionManager);
    }
}
