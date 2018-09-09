package com.frost_fox.jenkins.job_addon.jenkins;

public class Jobs {

    public static String BUILD_ID = Builds.ID;
    public static String NO_SUCH_BUILD_ID = Builds.NO_SUCH_BUILD_ID;
    public static String ADDON_ID = Builds.ADDON_ID;
    public static String NO_SUCH_ADDON_ID = Builds.NO_SUCH_ADDON_ID;

    private Builds builds = Builds.get();

    public static Jobs get() {
        return new Jobs();
    }

    public static JenkinsJob common() {
        return get().create();
    }

    public Jobs withBuilds(Builds builds) {
        this.builds = builds;
        return this;
    }

    public JenkinsJob create() {
        return JenkinsJob.from(builds.create());
    }

}
