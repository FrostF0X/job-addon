package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.AddonContextBuilder;
import com.frost_fox.jenkins.job_addon.jenkins.BuildBuilder;
import com.frost_fox.jenkins.job_addon.jenkins.ContextActionBuilder;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.JobBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = new JobDescriptionFactory(new FakeAddonExecutionManager());

    @Test
    public void createsDescriptionFromJob() {
        ContextActionBuilder actions = ContextActionBuilder.get().forContexts(AddonContextBuilder.get());
        JenkinsJob job = JobBuilder.get().withBuilds(BuildBuilder.get().withId("id").withActions(actions)).create();

        AddonExecutionBuilder addonExecutions = AddonExecutionBuilder.get().forContexts(AddonContextBuilder.get());
        JobDescription expected = JobDescriptionBuilder.get().withBuilds(BuildDescriptionBuilder.get().withId("id").withExecutions(addonExecutions)).create();

        JobDescription description = factory.create(job);

        assertEquals(description, expected);
    }

}
