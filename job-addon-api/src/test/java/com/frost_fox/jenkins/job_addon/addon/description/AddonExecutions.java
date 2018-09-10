package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionUrls;

import java.util.List;
import java.util.stream.Collectors;

public class AddonExecutions {

    public static final String NAME = AddonContexts.NAME;
    public static final List<String> IDS = AddonContexts.IDS;
    public static final String ID = AddonContexts.ID;
    public static final String NO_SUCH_ADDON_ID = AddonContexts.NO_SUCH_ADDON_ID;

    private AddonContexts contexts = AddonContexts.get();
    private AddonExecutionUrls urls = AddonExecutionUrls.get();
    private FakeAddonExecutionManager executionManager = new FakeAddonExecutionManager();

    public static AddonExecutions get() {
        return new AddonExecutions();
    }

    public AddonExecutions forContexts(AddonContexts contexts) {
        this.contexts = contexts;
        return this;
    }

    public AddonExecutions withUrl(AddonExecutionUrls url) {
        this.urls = url;
        return this;
    }

    public List<AddonExecution> all() {
        return this.contexts.all().stream().map(this::createAddonExecution).collect(Collectors.toList());
    }

    public AddonExecution one() {
        return all().get(0);
    }

    private AddonExecution createAddonExecution(AddonContext context) {
        return new AddonExecution(context, urls.one(), executionManager);
    }
}
