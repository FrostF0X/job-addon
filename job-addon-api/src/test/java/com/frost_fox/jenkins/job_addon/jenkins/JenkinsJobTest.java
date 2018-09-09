package com.frost_fox.jenkins.job_addon.jenkins;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class JenkinsJobTest {

    private final int MAX = JenkinsJob.MAX_JOBS;
    private final int MORE = JenkinsJob.MAX_JOBS + 10;
    private final int LESS = JenkinsJob.MAX_JOBS - 1;

    @Test
    public void returnsOnlyTenLastBuilds() {
        JenkinsJob job = Jobs.get().withBuilds(Builds.get().withCount(MORE)).all();

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds).isEqualTo(Builds.get().withCount(MAX).all());
    }

    @Test
    public void returnsSameBuildsIfLessThatTenGiven() {
        JenkinsJob job = Jobs.get().withBuilds(Builds.get().withCount(LESS)).all();

        List<JenkinsBuild> acquiredBuilds = job.getBuilds();
        assertThat(acquiredBuilds).isEqualTo(Builds.get().withCount(LESS).all());
    }
}