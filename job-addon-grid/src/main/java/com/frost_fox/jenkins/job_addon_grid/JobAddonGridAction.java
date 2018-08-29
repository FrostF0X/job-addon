package com.frost_fox.jenkins.job_addon_grid;

import com.frost_fox.jenkins.job_addon.api.JobDescriptionApiAction;
import hudson.Extension;
import hudson.model.Action;
import hudson.model.InvisibleAction;
import jenkins.model.Jenkins;
import jenkins.model.TransientActionFactory;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class JobAddonGridAction extends InvisibleAction {

    private final String url;

    public JobAddonGridAction(WorkflowJob job) {
        this.url = (new JobDescriptionApiAction(job)).getFullUrl();
    }

    public String getApiUrl() {
        return getJenkinsUrl() + url;
    }

    private String getJenkinsUrl() {
        return Objects.requireNonNull(Jenkins.getInstance()).getRootUrl();
    }


    @Extension
    public static class JobAddonActionFactory extends TransientActionFactory<WorkflowJob> {

        @Override
        public Class<WorkflowJob> type() {
            return WorkflowJob.class;
        }

        @Nonnull
        public Collection<? extends Action> createFor(@Nonnull WorkflowJob job) {
            return Collections.singleton(new JobAddonGridAction(job));
        }
    }
}
