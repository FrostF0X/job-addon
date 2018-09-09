package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.Ids;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BuildBuilder {

    @SuppressWarnings("WeakerAccess")
    public static final List<String> IDS = Ids.IDS;
    public static final String ID = Ids.ID_FROM_IDS;
    public static final String NO_SUCH_BUILD_ID = Ids.ID_NOT_FROM_IDS;
    public static final String ADDON_ID = ContextActionBuilder.ID;
    public static final String NO_SUCH_ADDON_ID = ContextActionBuilder.NO_SUCH_ADDON_ID;


    private List<String> ids = IDS;
    private ActionBuilder actions = ContextActionBuilder.get();

    public static BuildBuilder get() {
        return new BuildBuilder();
    }

    public BuildBuilder withId(String id) {
        return withIds(Collections.singletonList(id));
    }

    @SuppressWarnings("WeakerAccess")
    public BuildBuilder withIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public BuildBuilder withActions(ActionBuilder actions) {
        this.actions = actions;
        return this;
    }

    public List<JenkinsBuild> create() {
        return ids.stream().map(id -> new JenkinsBuild(actions.create(), id)).collect(Collectors.toList());
    }

    public BuildBuilder withCount(int count) {
        return withIds(Ids.exactCount(count));
    }

    public JenkinsBuild single() {
        return create().get(0);
    }
}
