package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.Ids;
import hudson.model.Action;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Builds {

    public static List<JenkinsBuild> singleWithActions(List<Action> actions) {
        return manyWithIds(Ids.SINGLE, actions);
    }

    public static JenkinsBuild singleOneWithActions(List<Action> actions) {
        return manyWithIds(Ids.SINGLE, actions).get(0);
    }

    public static List<JenkinsBuild> exactCountWithActions(int id, List<Action> actions){
        return manyWithIds(Ids.exactCount(id), actions);
    }

    public static List<JenkinsBuild> manyWithIds(List<String> ids, List<Action> actions) {
        return ids.stream().map(id -> new JenkinsBuild(actions, id)).collect(Collectors.toList());
    }

    public static List<JenkinsBuild> singleOne(String id, List<Action> actions) {
        return manyWithIds(Collections.singletonList(id), actions);
    }
}
