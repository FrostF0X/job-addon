package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;
import hudson.model.Run;
import jenkins.model.Jenkins;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class JenkinsJob {

    public static final int MAX_JOBS = 10;
    private List<JenkinsBuild> builds;
    private String url;

    @SuppressWarnings("WeakerAccess")
    public JenkinsJob(List<JenkinsBuild> builds, String url) {
        this.builds = getLast(builds);
        this.url = url;
    }

    public static JenkinsJob from(Job job) {
        List<JenkinsBuild> builds = ((List<Run>) job.getBuilds()).stream().map(JenkinsBuild::new)
                .collect(Collectors.toList());
        String url = getUrl(job);
        return new JenkinsJob(builds, url);
    }

    private static String getUrl(Job job) {
        Jenkins jenkins = Jenkins.getInstance();
        if(jenkins == null){
            throw new RuntimeException("Jenkins is not defined");
        }
        return jenkins.getRootUrl() + job.getUrl();
    }

    public static JenkinsJob from(List<JenkinsBuild> builds, String url) {
        return new JenkinsJob(builds, url);
    }

    private List<JenkinsBuild> getLast(List<JenkinsBuild> builds) {
        if (builds.size() > MAX_JOBS) {
            return builds.subList(0, MAX_JOBS);
        }
        return builds;
    }

    public List<JenkinsBuild> getBuilds() {
        return builds;
    }

    public String getUrl() {
        return url;
    }
}
