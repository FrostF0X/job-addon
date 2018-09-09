package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.Ids;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Builds {

    @SuppressWarnings("WeakerAccess")
    public static final List<String> IDS = Ids.IDS;
    public static final String ID = Ids.ID_FROM_IDS;
    public static final String NO_SUCH_BUILD_ID = Ids.ID_NOT_FROM_IDS;
    public static final String ADDON_ID = ContextActions.ID;
    public static final String NO_SUCH_ADDON_ID = ContextActions.NO_SUCH_ADDON_ID;


    private List<String> ids = IDS;
    private Actions actions = ContextActions.get();

    public static Builds get() {
        return new Builds();
    }

    public Builds withId(String id) {
        return withIds(Collections.singletonList(id));
    }

    @SuppressWarnings("WeakerAccess")
    public Builds withIds(List<String> ids) {
        this.ids = ids;
        return this;
    }

    public Builds withActions(Actions actions) {
        this.actions = actions;
        return this;
    }

    public List<JenkinsBuild> all() {
        return ids.stream().map(id -> new JenkinsBuild(actions.all(), id)).collect(Collectors.toList());
    }

    public Builds withCount(int count) {
        return withIds(Ids.exactCount(count));
    }

    public JenkinsBuild one() {
        return all().get(0);
    }
}
