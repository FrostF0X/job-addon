package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.addon.description.FakeAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddonExecutionFactoryTest {

    private static final long ESTIMATION = 200;
    @Mock
    private FakeAddonExecutionManager executionManager;
    @Mock
    private JenkinsJobRepository repository;
    private JenkinsJob job = Jobs.get().one();
    private JenkinsBuild build = Builds.get().one();
    private AddonContext context = AddonContexts.get().one();

    @Test
    public void createsAddonExecutionWithCreatedUrl() throws NoSuchJob {
        executionManager = new FakeAddonExecutionManager();
        AddonExecutionFactory factory = new AddonExecutionFactory(executionManager, repository);

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getUrl()).isEqualTo(new AddonExecutionUrl(Jobs.URL, Builds.ID, AddonContexts.ID));
    }

    @Test
    public void createsAddonExecutionWithExecutionManager() throws AddonExecutionException, NoSuchJob {
        AddonExecutionFactory factory = new AddonExecutionFactory(executionManager, repository);

        AddonExecution execution = factory.create(job, build, context);
        execution.start();

        verify(executionManager, times(1)).startAndGetId(any());
    }

    @Test
    public void createsAddonExecutionWithEstimationTakenFromJob() throws NoSuchJob {
        AddonExecutionFactory factory = new AddonExecutionFactory(executionManager, repository);

        given(repository.getEstimation(any())).willReturn(ESTIMATION);
        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getAddon().getEstimation()).isEqualTo(ESTIMATION);
    }

}