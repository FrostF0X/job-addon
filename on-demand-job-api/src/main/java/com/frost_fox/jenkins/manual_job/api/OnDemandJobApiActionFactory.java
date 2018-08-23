package com.frost_fox.jenkins.manual_job.api;

import hudson.Extension;
import hudson.model.Action;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

@Extension
public class OnDemandJobApiActionFactory extends TransientActionFactory<WorkflowJob> {

    @Override
    public Class<WorkflowJob> type() {
        return WorkflowJob.class;
    }

    @Nonnull
    @Override
    public Collection<? extends Action> createFor(@Nonnull WorkflowJob workflowJob) {
        return Collections.singleton(new OnDemandJobApiAction(workflowJob));
    }
}