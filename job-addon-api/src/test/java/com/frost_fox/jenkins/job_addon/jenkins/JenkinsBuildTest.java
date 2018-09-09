package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.AddonContextBuilder;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JenkinsBuildTest {

    @Test
    public void returnsAllAddonActionsTakenFromAddonContextActions() {
        JenkinsBuild build =
                BuildBuilder.get().withActions(ContextActionBuilder.get().forContexts(AddonContextBuilder.get())).single();

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons).isEqualTo(ContextActionBuilder.get().forContexts(AddonContextBuilder.get()).create());
    }

    @Test
    public void returnsOnlyAddonActionsFromAllActions() {
        JenkinsBuild build =
                BuildBuilder.get().withActions(ContextActionBuilder.get()
                        .forContexts(AddonContextBuilder.get()).and(FakeActions.get())).single();

        List<AddonContextAction> extractedAddons = build.getAddonActions();

        assertThat(extractedAddons).isEqualTo(ContextActionBuilder.get().forContexts(AddonContextBuilder.get()).create());
    }
}