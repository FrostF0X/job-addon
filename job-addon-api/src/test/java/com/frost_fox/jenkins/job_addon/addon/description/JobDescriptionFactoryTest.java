package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.ContextActions;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.Jobs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = new JobDescriptionFactory(new FakeAddonExecutionManager());

    @Test
    public void createsDescriptionFromJob() {
        ContextActions actions = ContextActions.get().forContexts(AddonContexts.get());
        JenkinsJob job = Jobs.get().withBuilds(Builds.get().withId("id").withActions(actions)).create();

        AddonExecutions addonExecutions = AddonExecutions.get().forContexts(AddonContexts.get());
        JobDescription expected = JobDescriptions.get().withBuilds(BuildDescriptions.get().withId("id").withExecutions(addonExecutions)).create();

        JobDescription description = factory.create(job);

        assertEquals(description, expected);
    }

}
