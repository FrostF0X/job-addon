package com.frost_fox.jenkins.job_addon.job;

import com.frost_fox.jenkins.job_addon.jenkins.Actions;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;

import javax.xml.ws.Action;

public class JenkinsJobAddonsDescriptionTest {

    @Action
    public void extractAddonsFromJob() {
        JenkinsJob job = new JenkinsJob(Builds.threeBuildsWithActions(Actions.addonContextActions()));
    }

}
