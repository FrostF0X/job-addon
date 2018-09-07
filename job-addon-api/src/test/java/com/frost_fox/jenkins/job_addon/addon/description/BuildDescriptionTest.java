package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.frost_fox.jenkins.job_addon.Ids.ID_FROM_IDS;
import static com.frost_fox.jenkins.job_addon.Ids.ID_NOT_FROM_IDS;
import static com.frost_fox.jenkins.job_addon.addon.AddonContexts.contextsForIds;
import static org.junit.Assert.assertEquals;

public class BuildDescriptionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void returnsAddonExecutionIfAddonExists() throws Exception {
        BuildDescription description = BuildDescriptions.singleOneWithAddons(AddonExecutions.forContexts(
                contextsForIds(Ids.IDS)));

        AddonExecution addonExecution = description.getAddonById(ID_FROM_IDS);

        assertEquals(addonExecution.getId(), ID_FROM_IDS);
    }

    @Test
    public void returnsNoSuchAddonExceptionIfAddonNotExists() throws Exception {
        BuildDescription description = BuildDescriptions.singleOneWithAddons(AddonExecutions.forContexts(
                contextsForIds(Ids.IDS)));

        exception.expect(NoSuchAddon.class);

        description.getAddonById(ID_NOT_FROM_IDS);
    }

}