package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.syntax.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JenkinsBuildTest {

    @Test
    public void returnsAllAddonActionsTakenFromAddonContextActions() {
        JenkinsBuild build = Builds.get().withActions(ContextActions.get().forContexts(AddonContexts.get())).one();

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons).isEqualTo(ContextActions.get().forContexts(AddonContexts.get()).all());
    }

    @Test
    public void returnsOnlyAddonActionsFromAllActions() {
        JenkinsBuild build = Builds.get().withActions(ContextActions.get()
                        .forContexts(AddonContexts.get()).and(FakeActions.get())).one();

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons).isEqualTo(ContextActions.get().forContexts(AddonContexts.get()).all());
    }
}