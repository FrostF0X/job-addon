package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionBuilder.ADDON_ID;
import static com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionBuilder.BUILD_ID;
import static com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionBuilder.NO_SUCH_BUILD_ID;
import static org.assertj.core.api.Assertions.assertThat;

public class JobDescriptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void returnsAddonByBuildIdAndJobIdIfSuchExists() throws Exception {
        JobDescription descriptionWithBuildsWithIds = JobDescriptionBuilder.get().create();

        AddonExecution addon = descriptionWithBuildsWithIds.getAddonByBuildIdAndJobId(BUILD_ID, ADDON_ID);

        assertThat(addon.getId()).isEqualTo(ADDON_ID);
    }

    @Test
    public void throwsExceptionIfSuchBuildIdNotExists() throws Exception {
        JobDescription descriptionWithBuildsWithIds = JobDescriptionBuilder.get().create();

        exception.expect(NoSuchBuild.class);

        descriptionWithBuildsWithIds.getAddonByBuildIdAndJobId(NO_SUCH_BUILD_ID, ADDON_ID);
    }

}
