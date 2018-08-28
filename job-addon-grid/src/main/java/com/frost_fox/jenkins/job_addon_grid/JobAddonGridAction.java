package com.frost_fox.jenkins.job_addon_grid;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.InvisibleAction;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class JobAddonGridAction extends InvisibleAction {

    @Extension
    public static class JobAddonActionFactory extends TransientActionFactory<WorkflowJob> {

        @Override
        public Class<WorkflowJob> type() {
            return WorkflowJob.class;
        }

        @Nonnull
        public Collection<? extends Action> createFor(@Nonnull WorkflowJob job) {
            return Collections.singleton(new JobAddonGridAction());
        }
    }
}
