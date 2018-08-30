package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.jenkins.Actions;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class JobDescriptionTest {

    @Test
    public void createsDescriptionFromJob(){
        JenkinsJob job = new JenkinsJob(Builds.singleBuildWithActions(Actions.forAddonsContext(AddonExecutions.context())));

        JobDescription description = JobDescription.from(job);
        JobDescription expected = new JobDescription(BuildDescriptions.single(AddonExecutions.forContext(AddonExecutions.context())));

        assertEquals(description, expected);
    }

}
