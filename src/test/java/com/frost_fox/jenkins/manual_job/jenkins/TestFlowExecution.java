package com.frost_fox.jenkins.manual_job.jenkins;

import hudson.model.Action;
import hudson.model.Result;
import jenkins.model.CauseOfInterruption;
import org.acegisecurity.Authentication;
import org.jenkinsci.plugins.workflow.flow.FlowExecution;
import org.jenkinsci.plugins.workflow.flow.FlowExecutionOwner;
import org.jenkinsci.plugins.workflow.flow.GraphListener;
import org.jenkinsci.plugins.workflow.graph.FlowNode;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

public class TestFlowExecution extends FlowExecution {

    @Override
    public void start() throws IOException {

    }

    @Override
    public FlowExecutionOwner getOwner() {
        return null;
    }

    @Override
    public List<FlowNode> getCurrentHeads() {
        return null;
    }

    @Override
    public boolean isCurrentHead(FlowNode flowNode) {
        return false;
    }

    @Override
    public void interrupt(Result result, CauseOfInterruption... causeOfInterruptions) {

    }

    @Override
    public void addListener(GraphListener graphListener) {

    }

    @CheckForNull
    @Override
    public FlowNode getNode(String s) {
        return null;
    }

    @Nonnull
    @Override
    public Authentication getAuthentication() {
        return null;
    }

    @Override
    public List<Action> loadActions(FlowNode flowNode) {
        return null;
    }

    @Override
    public void saveActions(FlowNode flowNode, List<Action> list) {

    }
}
