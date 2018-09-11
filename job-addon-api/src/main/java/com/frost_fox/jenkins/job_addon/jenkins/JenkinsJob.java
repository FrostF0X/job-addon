package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;
import hudson.model.Run;
import jenkins.model.Jenkins;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class JenkinsJob {

    public static final int MAX_JOBS = 10;
    private List<JenkinsBuild> builds;
    private String url;
    private long estimation;

    @SuppressWarnings("WeakerAccess")
    public JenkinsJob(List<JenkinsBuild> builds, String url, long estimation) {
        this.builds = getLast(builds);
        this.url = url;
        this.estimation = estimation;
    }

    public static JenkinsJob from(Job job) {
        List<JenkinsBuild> builds = ((List<Run>) job.getBuilds()).stream().map(JenkinsBuild::new)
                .collect(Collectors.toList());
        String url = getUrl(job);
        long estimation = job.getEstimatedDuration();
        return new JenkinsJob(builds, url, estimation);
    }

    private static String getUrl(Job job) {
        Jenkins jenkins = Jenkins.getInstance();
        if(jenkins == null){
            throw new RuntimeException("Jenkins is not defined");
        }
        return jenkins.getRootUrl() + job.getUrl();
    }

    public static JenkinsJob from(List<JenkinsBuild> builds, String url, long estimation) {
        return new JenkinsJob(builds, url, estimation);
    }

    private List<JenkinsBuild> getLast(List<JenkinsBuild> builds) {
        if (builds.size() > MAX_JOBS) {
            return builds.subList(0, MAX_JOBS);
        }
        return builds;
    }

    public long getEstimation() {
        return estimation;
    }

    public List<JenkinsBuild> getBuilds() {
        return builds;
    }

    public String getUrl() {
        return url;
    }
}
