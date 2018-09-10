package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.addon.description.FakeAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.Builds;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsBuild;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.Jobs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddonExecutionFactoryTest {

    @Mock
    private FakeAddonExecutionManager executionManager;
    private JenkinsJob job = Jobs.get().one();
    private JenkinsBuild build = Builds.get().one();
    private AddonContext context = AddonContexts.get().one();

    @Test
    public void createsAddonExecutionWithCreatedUrl() {
        executionManager = new FakeAddonExecutionManager();
        AddonExecutionFactory factory = new AddonExecutionFactory(executionManager);

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getUrl()).isEqualTo(new AddonExecutionUrl(Jobs.URL, Builds.ID, AddonContexts.ID));
    }

    @Test
    public void createsAddonExecutionWithExecutionManager() throws AddonExecutionException {
        AddonExecutionFactory factory = new AddonExecutionFactory(executionManager);

        AddonExecution execution = factory.create(job, build, context);
        execution.start();

        verify(executionManager, times(1)).startAndGetId(any());
    }

}