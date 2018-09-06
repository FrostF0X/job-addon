package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import hudson.model.Job;

public class AddonRepository {

    private Job job;

    public AddonRepository(Job job) {
        this.job = job;
    }

    public void save(AddonExecution execution) throws AddonRepositoryException{
        saveWholeJob();
    }

    public void save(Addon addon) throws AddonRepositoryException {
        saveWholeJob();
    }

    private void saveWholeJob() throws AddonRepositoryException {
        try {
            this.job.save();
        } catch (Exception e) {
            throw new AddonRepositoryException("Can't save changes to repository");
        }
    }
}
