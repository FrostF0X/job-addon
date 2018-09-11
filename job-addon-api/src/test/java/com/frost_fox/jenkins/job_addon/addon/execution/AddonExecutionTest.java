package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.description.AddonExecutions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddonExecutionTest {

    @Test
    public void getUrlStringReturnsUrlString() {
        AddonExecutionUrls url = AddonExecutionUrls.get();
        AddonExecution execution = AddonExecutions.get().withUrl(url).one();

        String stringUrl = execution.getUrlString();

        assertThat(stringUrl).isEqualTo(url.one().toString());
    }

}