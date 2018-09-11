package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.Result;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJob;
import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.Jobs;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.frost_fox.jenkins.job_addon.ResultAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class JobDescriptionUseCaseTest {

    @Test
    public void returnsSuccessResultWithJobDescription() {
        JenkinsJob job = Jobs.common();

        Result<JobDescription> result = useCase.execute(job);

        assertThat(result).successful();
    }

    @Test
    public void returnsFailResultWithMessageWhenJobWasNotFound() throws NoSuchJob {
        JenkinsJob job = Jobs.common();

        given(repository.getEstimation(any())).willThrow(exception);

        Result<JobDescription> result = useCase.execute(job);

        assertThat(result).failedWith(exception.getMessage());
    }

    @Mock
    public JenkinsJobRepository repository;
    private JobDescriptionUseCase useCase;
    private NoSuchJob exception = new NoSuchJob("id");

    @Before
    public void setUp() {
        this.useCase = new JobDescriptionUseCase(FakeJobDescriptionFactories.get().withRepository(repository).one());
    }
}