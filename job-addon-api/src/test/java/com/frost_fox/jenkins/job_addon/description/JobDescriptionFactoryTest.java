package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.jenkins.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = FakeJobDescriptionFactories.get().one();

    @Test
    public void createsDescriptionFromJob() throws NoSuchJob, NoSuchBuild {
        JenkinsJob job = Jobs.get().withBuilds(Builds.get().withId("id")
                .withActions(ContextActions.get().forContexts(AddonContexts.get()))).one();

        JobDescription expected = JobDescriptions.get().withBuilds(BuildDescriptions.get().withId("id")
                .withExecutions(AddonExecutions.get().forContexts(AddonContexts.get()))).all();

        JobDescription description = factory.create(job);

        assertEquals(description, expected);
    }

}
