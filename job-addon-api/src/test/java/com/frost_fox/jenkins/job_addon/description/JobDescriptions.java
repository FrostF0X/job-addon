package com.frost_fox.jenkins.job_addon.description;

public class JobDescriptions {

    public static final String BUILD_ID = BuildDescriptions.ID;
    public static final String NO_SUCH_BUILD_ID = BuildDescriptions.NO_SUCH_BUILD_ID;
    public static final String ADDON_ID = BuildDescriptions.ADDON_ID;
    public static final String NO_SUCH_ADDON_ID = BuildDescriptions.NO_SUCH_ADDON_ID;
    @SuppressWarnings("WeakerAccess")
    public static final int ESTIMATION = 1000;

    private BuildDescriptions builds = BuildDescriptions.get();
    private long estimation = ESTIMATION;

    public static JobDescriptions get() {
        return new JobDescriptions();
    }

    public static JobDescription common() {
        return get().all();
    }

    public JobDescriptions withBuilds(BuildDescriptions builds) {
        this.builds = builds;
        return this;
    }

    public JobDescription all() {
        return new JobDescription(builds.all(), estimation);
    }

}
