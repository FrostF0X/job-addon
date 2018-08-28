package com.frost_fox.jenkins.job_addon.jenkins;

import java.util.ArrayList;
import java.util.List;

public class Builds {

    public static List<JenkinsBuild> threeBuildsWithActions(List<JenkinsAction> actions) {
        List<JenkinsBuild> builds = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            builds.add(new JenkinsBuild(actions));
        }
        return builds;
    }

}
