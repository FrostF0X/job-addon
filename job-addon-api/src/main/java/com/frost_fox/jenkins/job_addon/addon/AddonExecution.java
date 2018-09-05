package com.frost_fox.jenkins.job_addon.addon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import hudson.model.*;
import hudson.model.queue.QueueTaskFuture;
import jenkins.model.Jenkins;
import jenkins.model.ParameterizedJobMixIn;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class AddonExecution {
    public final Addon addon;
    private AddonContext context;

    public AddonExecution(AddonContext context) {
        this.context = context;
        addon = new Addon(context);
    }

    public Addon getAddon() {
        return addon;
    }

    @JsonIgnore
    public String getId() {
        return getAddon().getId();
    }

    public void start() throws ExecutionException, InterruptedException {
        Job job = (Job) Jenkins.getInstance().getItem(context.getId());
        Jenkins.getInstance().getQueue().schedule2(job, 0, new CauseAction(new Cause() {
            @Override
            public String getShortDescription() {
                return "test";
            }
        })).getItem();
        QueueTaskFuture<WorkflowRun> future = job.scheduleBuild2(0);
        WorkflowRun run = future.waitForStart();
        this.context.setLastRunId(run.getId());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AddonExecution && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addon);
    }
}
