package com.frost_fox.jenkins.job_addon.api;

import hudson.Extension;
import hudson.model.Action;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

@Extension
public class AddonExecutionApiActionFactory extends TransientActionFactory<WorkflowJob> {

    @Override
    public Class<WorkflowJob> type() {
        return WorkflowJob.class;
    }

    @Nonnull
    @Override
    public Collection<? extends Action> createFor(@Nonnull WorkflowJob workflowJob) {
        return Collections.singleton(new AddonExecutionApiAction(workflowJob));
    }
}
