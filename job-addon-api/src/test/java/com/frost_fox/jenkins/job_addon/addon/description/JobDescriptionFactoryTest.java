package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions;
import com.frost_fox.jenkins.job_addon.addon.execution.FakeAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.Actions;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import org.junit.jupiter.api.Test;

import static com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions.context;
import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = new JobDescriptionFactory(new FakeAddonExecutionManager());

    @Test
    public void createsDescriptionFromJob() {
        JenkinsJob job = new JenkinsJob(Builds.singleWithActions(Actions.forAddonsContext(context())));

        JobDescription description = factory.create(job);
        JobDescription expected = new JobDescription(BuildDescriptions.single(AddonExecutions.forContext(context())));

        assertEquals(description, expected);
    }

}
