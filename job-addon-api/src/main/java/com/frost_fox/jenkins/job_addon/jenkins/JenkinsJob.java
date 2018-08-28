package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;
import hudson.model.Run;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class JenkinsJob {

    private List<JenkinsBuild> builds;

    public static JenkinsJob from(Job job) {
        return new JenkinsJob(((List<Run>) job.getBuilds()).stream().map(JenkinsBuild::new).collect(Collectors.toList()));
    }

    public JenkinsJob(List<JenkinsBuild> builds) {
        this.builds = builds;
    }

    public List<JenkinsBuild> getBuilds() {
        return builds;
    }
}
