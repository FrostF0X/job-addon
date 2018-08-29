package com.frost_fox.jenkins.job_addon.jenkins;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class JenkinsJobTest {

    private final int MAX = JenkinsJob.MAX_JOBS;
    private final int MORE = JenkinsJob.MAX_JOBS + 10;
    private final int LESS = JenkinsJob.MAX_JOBS - 1;

    @Test
    public void returnsOnlyTenLastBuilds() {
        JenkinsJob job = new JenkinsJob(Builds.buildsWithActions(MORE, Actions.arbitraryActions()));

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds, is(Builds.buildsWithActions(MAX, Actions.arbitraryActions())));
    }

    @Test
    public void returnsSameBuildsIfLessThatTenGiven() {
        JenkinsJob job = new JenkinsJob(Builds.buildsWithActions(LESS, Actions.arbitraryActions()));

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds, is(Builds.buildsWithActions(LESS, Actions.arbitraryActions())));
    }
}