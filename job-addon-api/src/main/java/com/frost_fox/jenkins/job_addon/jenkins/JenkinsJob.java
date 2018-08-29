package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;
import hudson.model.Run;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class JenkinsJob {

    public static final int MAX_JOBS = 10;
    private List<JenkinsBuild> builds;

    public static JenkinsJob from(Job job) {
        return new JenkinsJob(((List<Run>) job.getBuilds()).stream().map(JenkinsBuild::new).collect(Collectors.toList()));
    }

    public JenkinsJob(List<JenkinsBuild> builds) {
        this.builds = getLast(builds);
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
}
