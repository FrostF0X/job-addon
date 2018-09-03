package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Action;

import java.util.ArrayList;
import java.util.List;

public class Builds {

    private static final String ID = "id";

    private static JenkinsBuild create(List<Action> actions) {
        return new JenkinsBuild(actions, ID);
    }

    public static List<JenkinsBuild> threeBuildsWithActions(List<Action> actions) {
        return buildsWithActions(3, actions);
    }

    public static List<JenkinsBuild> singleBuildWithActions(List<Action> actions) {
        return buildsWithActions(1, actions);
    }


    public static JenkinsBuild buildWithActions(List<Action> actions) {
        return buildsWithActions(1, actions).get(0);
    }


    public static List<JenkinsBuild> buildsWithActions(int count, List<Action> actions) {
        List<JenkinsBuild> builds = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            builds.add(create(actions));
        }
        return builds;
    }

}
