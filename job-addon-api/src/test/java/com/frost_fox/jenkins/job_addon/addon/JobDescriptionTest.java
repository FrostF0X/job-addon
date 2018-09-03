package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.jenkins.Actions;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import org.junit.jupiter.api.Test;

import static com.frost_fox.jenkins.job_addon.Ids.IDS;
import static com.frost_fox.jenkins.job_addon.Ids.ID_FROM_IDS;
import static com.frost_fox.jenkins.job_addon.addon.AddonExecutions.context;
import static org.junit.Assert.assertEquals;

public class JobDescriptionTest {

    @Test
    public void createsDescriptionFromJob() {
        JenkinsJob job = new JenkinsJob(Builds.singleBuildWithActions(Actions.forAddonsContext(context())));

        JobDescription description = JobDescription.from(job);
        JobDescription expected = new JobDescription(BuildDescriptions.single(AddonExecutions.forContext(context())));

        assertEquals(description, expected);
    }

    @Test
    public void returnsAddonByBuildIdAndJobIdIfSuchExists() throws Exception {
        JobDescription descriptionWithBuildsWithIds =
                new JobDescription(BuildDescriptions.manyWithIds(IDS, AddonExecutions.forContext(context())));

        AddonExecution addon = descriptionWithBuildsWithIds.getAddonByBuildIdAndJobId(ID_FROM_IDS, AddonExecutions.ID);

        assertEquals(addon.getId(), AddonExecutions.ID);
    }

}
