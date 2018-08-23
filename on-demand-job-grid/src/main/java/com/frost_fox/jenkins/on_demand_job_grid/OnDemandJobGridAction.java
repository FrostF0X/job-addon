package com.frost_fox.jenkins.on_demand_job_grid;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.InvisibleAction;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class OnDemandJobGridAction extends InvisibleAction {

    @Extension
    public static class OnDemandJobGridActionFactory extends TransientActionFactory<WorkflowJob> {

        @Override
        public Class<WorkflowJob> type() {
            return WorkflowJob.class;
        }

        @Nonnull
        public Collection<? extends Action> createFor(@Nonnull WorkflowJob job) {
            return Collections.singleton(new OnDemandJobGridAction());
        }
    }
}
