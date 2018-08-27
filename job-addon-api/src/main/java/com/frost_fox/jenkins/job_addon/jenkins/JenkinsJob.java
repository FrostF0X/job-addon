package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Job;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import java.util.List;

public class JenkinsJob {

    private List<JenkinsBuild> builds;

    public JenkinsJob(List<JenkinsBuild> builds) {
        this.builds = builds;
    }

}
