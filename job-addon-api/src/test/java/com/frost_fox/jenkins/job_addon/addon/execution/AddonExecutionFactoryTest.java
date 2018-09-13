package com.frost_fox.jenkins.job_addon.addon.execution;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.NoSuchEntity;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;
import com.frost_fox.jenkins.job_addon.description.BuildInfo;
import com.frost_fox.jenkins.job_addon.description.BuildInfoRepository;
import com.frost_fox.jenkins.job_addon.description.BuildStatus;
import com.frost_fox.jenkins.job_addon.jenkins.*;
import org.junit.Before;
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
    private static final BuildInfo STATUS = new BuildInfo(BuildStatus.Running, 200);
    @Mock
    private FakeAddonExecutionManager executionManager;
    @Mock
    private JenkinsJobRepository repository;
    @Mock
    private BuildInfoRepository infoRepository;
    private JenkinsJob job = Jobs.get().one();
    private JenkinsBuild build = Builds.get().one();
    private AddonContext context = AddonContexts.get().one();
    private AddonExecutionFactory factory;

    @Test
    public void createsAddonExecutionWithCreatedUrl() throws NoSuchEntity {
        executionManager = new FakeAddonExecutionManager();

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getUrl()).isEqualTo(new AddonExecutionUrl(Jobs.URL, Builds.ID, AddonContexts.ID));
    }

    @Test
    public void createsAddonExecutionWithExecutionManager() throws AddonExecutionException, NoSuchEntity {
        AddonExecution execution = factory.create(job, build, context);

        execution.start();

        verify(executionManager, times(1)).startAndGetId(any());
    }

    @Test
    public void createsAddonExecutionWithEstimationTakenFromJob() throws NoSuchEntity {
        given(repository.getEstimation(any())).willReturn(ESTIMATION);

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getAddon().getEstimation()).isEqualTo(ESTIMATION);
    }

    @Test
    public void createsAddonExecutionWithBuildInformation() throws NoSuchEntity {
        AddonContext context = AddonContexts.get().withLastRunId("id").one();

        given(infoRepository.getByJobAndBuildId(any(), any())).willReturn(STATUS);

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getLastBuildInfo()).isEqualTo(STATUS);
    }

    @Test
    public void createsAddonExecutionWithDefaultBuildInformationIfContextLastBuildNumberIsNotSpecified() throws NoSuchEntity {
        AddonContext context = AddonContexts.get().withEmptyLastRunId().one();

        AddonExecution execution = factory.create(job, build, context);

        assertThat(execution.getLastBuildInfo()).isEqualTo(BuildInfo.common());
    }

    @Before
    public void setUp() {
        factory = new AddonExecutionFactory(executionManager, repository, infoRepository);
    }
}