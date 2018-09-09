package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.frost_fox.jenkins.job_addon.addon.description.BuildDescriptions.ID;
import static com.frost_fox.jenkins.job_addon.addon.description.BuildDescriptions.NO_SUCH_BUILD_ID;
import static org.junit.Assert.assertEquals;

public class BuildDescriptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void returnsAddonExecutionIfAddonExists() throws Exception {
        BuildDescription description = BuildDescriptions.get().single();

        AddonExecution addonExecution = description.getAddonById(ID);

        assertEquals(addonExecution.getId(), ID);
    }

    @Test
    public void returnsNoSuchAddonExceptionIfAddonNotExists() throws Exception {
        BuildDescription description = BuildDescriptions.get().single();

        exception.expect(NoSuchAddon.class);

        description.getAddonById(NO_SUCH_BUILD_ID);
    }

}