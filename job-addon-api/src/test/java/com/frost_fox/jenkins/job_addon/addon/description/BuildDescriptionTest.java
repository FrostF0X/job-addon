package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions;
import org.junit.Test;

import static com.frost_fox.jenkins.job_addon.addon.AddonContexts.contextsForIds;
import static org.junit.Assert.assertEquals;

public class BuildDescriptionTest {

    @Test
    public void returnsAddonExecutionForIdIfExist() throws Exception {
        BuildDescription description = BuildDescriptions.singleOneWithAddons(AddonExecutions.forContexts(
                contextsForIds(Ids.IDS)));

        AddonExecution addonExecution = description.getAddonById(Ids.ID_FROM_IDS);

        assertEquals(addonExecution.getId(), Ids.ID_FROM_IDS);
    }


}