package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import org.junit.Test;

import java.util.List;

import static com.frost_fox.jenkins.job_addon.addon.AddonContexts.context;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JenkinsBuildTest {

    @Test
    public void returnsAllAddonActionsTakenFromAddonContextActions() {
        JenkinsBuild build = Builds.singleOneWithActions(Actions.forAddonContext(context()));

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons, is(Actions.forAddonContext(context())));
    }

    @Test
    public void returnsOnlyAddonActionsFromAllActions() {
        JenkinsBuild build = Builds.singleOneWithActions(
                Actions.mix(Actions.arbitraryActions(), Actions.forAddonContext(context()))
        );

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons, is(Actions.forAddonContext(context())));
    }
}