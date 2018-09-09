package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;

public class JobBuilder {

    public static String BUILD_ID = BuildBuilder.ID;
    public static String NO_SUCH_BUILD_ID = BuildBuilder.NO_SUCH_BUILD_ID;
    public static String ADDON_ID = BuildBuilder.ADDON_ID;
    public static String NO_SUCH_ADDON_ID = BuildBuilder.NO_SUCH_ADDON_ID;

    private BuildBuilder builds = BuildBuilder.get();

    public static JobBuilder get() {
        return new JobBuilder();
    }

    public static JenkinsJob common() {
        return get().create();
    }

    public JobBuilder withBuilds(BuildBuilder builds) {
        this.builds = builds;
        return this;
    }

    public JenkinsJob create() {
        return JenkinsJob.from(builds.create());
    }

}
