package com.frost_fox.jenkins.manual_job;

import hudson.model.Action;
import org.jenkinsci.plugins.workflow.graph.FlowNode;

import java.util.List;

public class FlowNodeContextExtractor {

    public static Context extract(FlowNode node) {
        List<Action> actions = node.getActions();
        RunContextAction contextAction = getContextAction(actions);
        return contextAction.getContext();
    }

    private static RunContextAction getContextAction(List<Action> actions) {
        for (Action action : actions) {
            if (action instanceof RunContextAction) {
                return (RunContextAction) action;
            }
        }
        return RunContextAction.empty();
    }

}
