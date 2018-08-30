package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.AddonExecutions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class JenkinsBuildTest {

    @Test
    public void returnsAllAddonActionsTakenFromAddonContextActions() {
        JenkinsBuild build = Builds.buildWithActions(Actions.forAddonsContext(AddonExecutions.context()));

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons, is(Actions.forAddonsContext(AddonExecutions.context())));
    }

    @Test
    public void returnsOnlyAddonActionsFromAllActions() {
        JenkinsBuild build = Builds.buildWithActions(
                Actions.mix(Actions.arbitraryActions(), Actions.forAddonsContext(AddonExecutions.context()))
        );

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons, is(Actions.forAddonsContext(AddonExecutions.context())));
    }
}