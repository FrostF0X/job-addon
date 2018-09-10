package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildDescriptions {

    @SuppressWarnings("WeakerAccess")
    public static final List<String> IDS = Ids.IDS;
    public static final String ID = Ids.FIRST_ID_FROM_IDS;
    public static final String NO_SUCH_BUILD_ID = Ids.ID_NOT_FROM_IDS;
    public static final String ADDON_ID = AddonExecutions.ID;
    public static final String NO_SUCH_ADDON_ID = AddonExecutions.NO_SUCH_ADDON_ID;

    private AddonExecutions addonExecutions = AddonExecutions.get();
    private List<String> ids = IDS;

    public static BuildDescriptions get() {
        return new BuildDescriptions();
    }

    public BuildDescriptions withIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public BuildDescriptions withId(String id) {
        this.ids = Collections.singletonList(id);
        return this;
    }

    public BuildDescriptions withExecutions(AddonExecutions addonExecutions) {
        this.addonExecutions = addonExecutions;
        return this;
    }

    public List<BuildDescription> all() {
        return ids.stream().map(this::buildForId).collect(Collectors.toList());
    }

    public BuildDescription one() {
        return all().get(0);
    }

    private BuildDescription buildForId(String id) {
        return new BuildDescription(addonExecutions.all(), id);
    }
}
