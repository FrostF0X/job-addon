package com.frost_fox.jenkins.job_addon.syntax;

import org.jenkinsci.plugins.workflow.steps.StepContext;
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
