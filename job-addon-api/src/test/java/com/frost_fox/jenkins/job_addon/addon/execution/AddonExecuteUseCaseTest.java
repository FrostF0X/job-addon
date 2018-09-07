package com.frost_fox.jenkins.job_addon.addon.execution;


import com.frost_fox.jenkins.job_addon.addon.AddonRepository;
import com.frost_fox.jenkins.job_addon.addon.description.JobDescriptionFactory;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.Jobs;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AddonExecuteUseCaseTest {

    @Mock
    private AddonRepository addonRepository;
    @Mock
    private AddonExecutionManager manager;
    private JobDescriptionFactory factory;
    private AddonExecuteUseCase useCase;

    @Test
    public void returnsJobIdIfSuchJobExistsIn() throws AddonExecutionException {
        JenkinsJob description = Jobs.jobWithSomeBuildsAndAddonActions();

        given(manager.startAndGetId(any())).willReturn("id");

        String result = useCase.execute(Jobs.BUILD_ID, Jobs.ADDON_ID, description);

        assertThat(result).isEqualTo("id");
    }

    @Before
    public void setUp() {
        factory = new JobDescriptionFactory(manager);
        useCase = new AddonExecuteUseCase(addonRepository, factory);
    }


}
