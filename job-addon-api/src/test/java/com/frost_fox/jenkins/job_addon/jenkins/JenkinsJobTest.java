package com.frost_fox.jenkins.job_addon.jenkins;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JenkinsJobTest {

    private final int MAX = JenkinsJob.MAX_JOBS;
    private final int MORE = JenkinsJob.MAX_JOBS + 10;
    private final int LESS = JenkinsJob.MAX_JOBS - 1;

    @Test
    public void returnsOnlyTenLastBuilds() {
        JenkinsJob job = new JenkinsJob(Builds.exactCountWithActions(MORE, Actions.arbitraryActions()));

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds, is(Builds.exactCountWithActions(MAX, Actions.arbitraryActions())));
    }

    @Test
    public void returnsSameBuildsIfLessThatTenGiven() {
        JenkinsJob job = new JenkinsJob(Builds.exactCountWithActions(LESS, Actions.arbitraryActions()));

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds, is(Builds.exactCountWithActions(LESS, Actions.arbitraryActions())));
    }
}