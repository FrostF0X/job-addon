package com.frost_fox.jenkins.job_addon.addon;

import com.frost_fox.jenkins.job_addon.Ids;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class BuildDescriptionTest {

    @Test
    public void returnsAddonExecutionForIdIfExist() throws Exception {
        BuildDescription description = BuildDescriptions.singleOne(AddonExecutions.forContexts(
                AddonExecutions.contextsForIds(Ids.IDS)
        ));

        AddonExecution addonExecution = description.getAddonById(Ids.ID_FROM_IDS);

        assertEquals(addonExecution.getId(), Ids.ID_NOT_FROM_IDS);
    }


}