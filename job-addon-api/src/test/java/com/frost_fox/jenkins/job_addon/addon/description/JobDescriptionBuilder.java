package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.jenkins.BuildBuilder;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class JobDescriptionBuilder {

    public static String BUILD_ID = BuildDescriptionBuilder.ID;
    public static String NO_SUCH_BUILD_ID = BuildDescriptionBuilder.NO_SUCH_BUILD_ID;
    public static String ADDON_ID = BuildDescriptionBuilder.ADDON_ID;
    public static String NO_SUCH_ADDON_ID = BuildDescriptionBuilder.NO_SUCH_ADDON_ID;

    private BuildDescriptionBuilder builds = BuildDescriptionBuilder.get();

    public static JobDescriptionBuilder get() {
        return new JobDescriptionBuilder();
    }

    public static JobDescription common() {
        return get().create();
    }

    public JobDescriptionBuilder withBuilds(BuildDescriptionBuilder builds) {
        this.builds = builds;
        return this;
    }

    public JobDescription create() {
        return new JobDescription(builds.create());
    }

}
