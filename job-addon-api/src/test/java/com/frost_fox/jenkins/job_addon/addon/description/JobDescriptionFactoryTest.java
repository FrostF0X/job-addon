package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions;
import com.frost_fox.jenkins.job_addon.jenkins.Actions;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import org.junit.Test;

import static com.frost_fox.jenkins.job_addon.addon.AddonContexts.context;
import static org.junit.Assert.assertEquals;

public class JobDescriptionFactoryTest {

    private JobDescriptionFactory factory = new JobDescriptionFactory(new FakeAddonExecutionManager());

    @Test
    public void createsDescriptionFromJob() {
        JenkinsJob job = new JenkinsJob(Builds.singleOne("id", Actions.forAddonContext(context())));

        JobDescription description = factory.create(job);
        JobDescription expected = new JobDescription(BuildDescriptions.single("id", AddonExecutions.forContext(context())));

        assertEquals(description, expected);
    }

}
