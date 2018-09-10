package com.frost_fox.jenkins.job_addon.jenkins;

public class Jobs {

    public static String BUILD_ID = Builds.ID;
    public static String NO_SUCH_BUILD_ID = Builds.NO_SUCH_BUILD_ID;
    public static String ADDON_ID = Builds.ADDON_ID;
    public static String NO_SUCH_ADDON_ID = Builds.NO_SUCH_ADDON_ID;
    public static String URL = "job";

    private Builds builds = Builds.get();
    private String url = URL;

    public static Jobs get() {
        return new Jobs();
    }

    public static JenkinsJob common() {
        return get().one();
    }

    public Jobs withBuilds(Builds builds) {
        this.builds = builds;
        return this;
    }

    public Jobs withUrl(String url) {
        this.url = url;
        return this;
    }

    public JenkinsJob one() {
        return JenkinsJob.from(builds.all(), url);
    }

}
