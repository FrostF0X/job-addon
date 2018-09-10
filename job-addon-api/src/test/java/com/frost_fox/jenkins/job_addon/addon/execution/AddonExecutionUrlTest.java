package com.frost_fox.jenkins.job_addon.addon.execution;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.frost_fox.jenkins.job_addon.api.AddonExecutionApiAction.BUILD_ID;
import static com.frost_fox.jenkins.job_addon.api.AddonExecutionApiAction.JOB_ID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AddonExecutionUrlTest {

    private final String HOST = "www.jenkins.com";
    private final String PATH = "/job/";
    private final String JOB_URL = HOST + PATH;

    @Test
    public void createsUrlThatStartsWithJobUrlAndJobAddon() {
        AddonExecutionUrl url = AddonExecutionUrls.get().withJobUrl(JOB_URL).one();

        String stringUrl = url.toString();

        assertThat(stringUrl).startsWith(JOB_URL);
    }

    @Test
    public void createsUrlThatContainsAddonIdParameter() throws URISyntaxException {
        AddonExecutionUrl url = AddonExecutionUrls.get().withAddonId("id").one();

        String stringUrl = url.toString();

        assertThat(new URI(stringUrl)).hasParameter(JOB_ID, "id");
    }

    @Test
    public void createsUrlThatContainsBuildIdParameter() throws URISyntaxException {
        AddonExecutionUrl url = AddonExecutionUrls.get().withBuildId("id").one();

        String stringUrl = url.toString();

        assertThat(new URI(stringUrl)).hasParameter(BUILD_ID, "id");
    }


}