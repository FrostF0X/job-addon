package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import hudson.model.Job;

public class XStreamAddonRepository implements AddonRepository {

    private Job job;

    public XStreamAddonRepository(Job job) {
        this.job = job;
    }

    @Override
    public void save(AddonExecution execution) throws AddonRepositoryException{
        saveWholeJob();
    }

    @Override
    public void save(Addon addon) throws AddonRepositoryException {
        saveWholeJob();
    }

    private void saveWholeJob() throws AddonRepositoryException {
        try {
            this.job.save();
        } catch (Exception e) {
            throw new AddonRepositoryException(MESSAGE);
        }
    }
}
