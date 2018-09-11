package com.frost_fox.jenkins.job_addon.jenkins;

import jenkins.model.Jenkins;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

public class XStreamJenkinsJobRepository implements JenkinsJobRepository {

    @Override
    public long getEstimation(String id) throws NoSuchJob {
        return getJob(id).getEstimatedDuration();
    }

    @SuppressWarnings("ConstantConditions")
    public WorkflowJob getJob(String id) throws NoSuchJob {
        try {
            WorkflowJob workflowJob = (WorkflowJob) Jenkins.getInstance().getItem(id);
            throwIfNull(workflowJob, id);
            return workflowJob;
        } catch (NullPointerException e) {
            throw new RuntimeException("Jenkins no present");
        } catch (ClassCastException e) {
            throw new NoSuchJob(id);
        }
    }

    private void throwIfNull(WorkflowJob workflowJob, String id) throws NoSuchJob {
        if (workflowJob == null) {
            throw new NoSuchJob(id);
        }
    }
}
