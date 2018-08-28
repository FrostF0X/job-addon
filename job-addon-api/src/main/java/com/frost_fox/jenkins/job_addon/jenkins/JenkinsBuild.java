package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import hudson.model.Action;
import hudson.model.Run;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class JenkinsBuild {
    private List<Action> actions;
    private String id;

    public JenkinsBuild(Run run){
        this((List<Action>) run.getAllActions(), run.getId());
    }

    public JenkinsBuild(List<Action> actions, String id) {
        this.actions = actions;
        this.id = id;
    }

    public List<AddonContextAction> getAddonActions() {
        return actions.stream().filter(action -> action instanceof AddonContextAction)
                .map(AddonContextAction.class::cast).collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }
}
