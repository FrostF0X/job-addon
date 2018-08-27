package com.frost_fox.jenkins.manual_job.jenkins;

import hudson.model.Action;
import org.jenkinsci.plugins.workflow.graph.FlowNode;

import java.util.Collections;
import java.util.List;

public class TestFlowNode extends FlowNode {

    private TestFlowNode() {
        super(new TestFlowExecution(), "id", Collections.<FlowNode>emptyList());
    }

    public TestFlowNode(Action action) {
        this(Collections.singletonList(action));
    }

    private TestFlowNode(List<Action> actions) {
        this();
        for (Action action : actions) {
            addAction(action);
        }
    }

    @Override
    protected String getTypeDisplayName() {
        return "Test node";
    }
}
