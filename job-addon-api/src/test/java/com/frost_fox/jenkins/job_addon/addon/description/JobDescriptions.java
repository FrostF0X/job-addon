package com.frost_fox.jenkins.job_addon.addon.description;

public class JobDescriptions {

    public static String BUILD_ID = BuildDescriptions.ID;
    public static String NO_SUCH_BUILD_ID = BuildDescriptions.NO_SUCH_BUILD_ID;
    public static String ADDON_ID = BuildDescriptions.ADDON_ID;
    public static String NO_SUCH_ADDON_ID = BuildDescriptions.NO_SUCH_ADDON_ID;

    private BuildDescriptions builds = BuildDescriptions.get();

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
        return new JobDescription(builds.all());
    }

}
