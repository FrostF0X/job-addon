package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;

public interface AddonRepository {
    void save(AddonExecution execution) throws AddonRepositoryException;

    void save(Addon addon) throws AddonRepositoryException;
}
