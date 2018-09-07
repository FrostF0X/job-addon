package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.frost_fox.jenkins.job_addon.addon.description.JobDescriptions.*;
import static org.junit.Assert.assertEquals;

public class JobDescriptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void returnsAddonByBuildIdAndJobIdIfSuchExists() throws Exception {
        JobDescription descriptionWithBuildsWithIds = JobDescriptions.withSomeBuildsAndAddons();

        AddonExecution addon = descriptionWithBuildsWithIds.getAddonByBuildIdAndJobId(BUILD_ID, ADDON_ID);

        assertEquals(addon.getId(), ADDON_ID);
    }

    @Test
    public void throwsExceptionIfSuchBuildIdNotExists() throws Exception {
        JobDescription descriptionWithBuildsWithIds = JobDescriptions.withSomeBuildsAndAddons();

        exception.expect(NoSuchBuild.class);

        descriptionWithBuildsWithIds.getAddonByBuildIdAndJobId(NO_SUCH_BUILD_ID, ADDON_ID);
    }

}
