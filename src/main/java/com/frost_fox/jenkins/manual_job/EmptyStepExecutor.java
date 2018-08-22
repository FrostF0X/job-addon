package com.frost_fox.jenkins.manual_job;

import jenkins.model.Jenkins;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.jenkinsci.plugins.workflow.steps.SynchronousStepExecution;

import javax.annotation.Nonnull;
import java.io.Serializable;

public class EmptyStepExecutor extends SynchronousStepExecution implements Serializable {

    protected EmptyStepExecutor(@Nonnull StepContext context) {
        super(context);
    }

    @Override
    protected Object run() {
        return null;
    }

}
