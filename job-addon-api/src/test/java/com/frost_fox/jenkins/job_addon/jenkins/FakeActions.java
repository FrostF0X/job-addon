package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import hudson.model.Action;

import java.util.List;
import java.util.stream.Collectors;

public class FakeActions implements Actions {

    @SuppressWarnings("WeakerAccess")
    public static final List<String> IDS = AddonContexts.IDS;
    public static final String ID = AddonContexts.ID;
    public static final String NO_SUCH_ADDON_ID = AddonContexts.NO_SUCH_ADDON_ID;

    private List<String> ids = IDS;

    public static FakeActions get() {
        return new FakeActions();
    }

    public List<Action> create() {
        return ids.stream().map(FakeAction::new).collect(Collectors.toList());
    }

}
