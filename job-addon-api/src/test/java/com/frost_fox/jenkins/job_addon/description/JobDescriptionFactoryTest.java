package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.FakeAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = new JobDescriptionFactory(
                    new AddonExecutionFactory(new FakeAddonExecutionManager(), new FakeJenkinsJobRepository())
            );

    @Test
    public void createsDescriptionFromJob() throws NoSuchJob {
        JenkinsJob job = Jobs.get().withBuilds(Builds.get().withId("id")
                .withActions(ContextActions.get().forContexts(AddonContexts.get()))).one();

        JobDescription expected = JobDescriptions.get().withBuilds(BuildDescriptions.get().withId("id")
                .withExecutions(AddonExecutions.get().forContexts(AddonContexts.get()))).all();

        JobDescription description = factory.create(job);

        assertEquals(description, expected);
    }

}
