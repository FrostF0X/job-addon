package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildDescriptionBuilder {

    @SuppressWarnings("WeakerAccess")
    public static final List<String> IDS = Ids.IDS;
    public static final String ID = Ids.ID_FROM_IDS;
    public static final String NO_SUCH_BUILD_ID = Ids.ID_NOT_FROM_IDS;
    public static final String ADDON_ID = AddonExecutionBuilder.ID;
    public static final String NO_SUCH_ADDON_ID = AddonExecutionBuilder.NO_SUCH_ADDON_ID;

    private AddonExecutionBuilder addonExecutions = AddonExecutionBuilder.get();
    private List<String> ids = IDS;

    public static BuildDescriptionBuilder get() {
        return new BuildDescriptionBuilder();
    }

    public BuildDescriptionBuilder withIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public BuildDescriptionBuilder withId(String id) {
        this.ids = Collections.singletonList(id);
        return this;
    }

    public BuildDescriptionBuilder withExecutions(AddonExecutionBuilder addonExecutions) {
        this.addonExecutions = addonExecutions;
        return this;
    }

    public List<BuildDescription> create() {
        return ids.stream().map(this::buildForId).collect(Collectors.toList());
    }

    public BuildDescription single() {
        return create().get(0);
    }

    private BuildDescription buildForId(String id) {
        return new BuildDescription(addonExecutions.create(), id);
    }
}
