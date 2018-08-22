package com.frost_fox.jenkins.manual_job;

import hudson.model.Action;
import org.jenkinsci.plugins.workflow.graph.FlowNode;

import java.util.List;

public class FlowNodeContextExtractor {

    public static Context extract(FlowNode node) {
        List<Action> actions = node.getActions();
        NodeContextAction contextAction = getContextAction(actions);
        return contextAction.getContext();
    }

    private static NodeContextAction getContextAction(List<Action> actions) {
        for (Action action : actions) {
            if (action instanceof NodeContextAction) {
                return (NodeContextAction) action;
            }
        }
        return NodeContextAction.empty();
    }

}
