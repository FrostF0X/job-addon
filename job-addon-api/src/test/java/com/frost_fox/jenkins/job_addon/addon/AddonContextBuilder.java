package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.Ids;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddonContextBuilder {

    public static final String NAME = "name";
    public static final List<String> IDS = Ids.IDS;
    public static final String ID = Ids.ID_FROM_IDS;
    public static final String NO_SUCH_ADDON_ID = Ids.ID_NOT_FROM_IDS;

    private List<String> ids = IDS;
    private String name = NAME;

    public static AddonContextBuilder get(){
        return new AddonContextBuilder();
    }

    public AddonContextBuilder withIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public AddonContextBuilder withId(String id) {
        this.ids = Collections.singletonList(id);
        return this;
    }

    public AddonContextBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public List<AddonContext> create() {
        return ids.stream().map(id -> new AddonContext(id, name)).collect(Collectors.toList());
    }

    public AddonContext single() {
        return create().get(0);
    }
}
