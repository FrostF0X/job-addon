package com.frost_fox.jenkins.job_addon.jenkins;

import java.util.List;

public class JenkinsBuild {
    private List<JenkinsAction> actions;

    public JenkinsBuild(List<JenkinsAction> actions) {
        this.actions = actions;
    }
}
