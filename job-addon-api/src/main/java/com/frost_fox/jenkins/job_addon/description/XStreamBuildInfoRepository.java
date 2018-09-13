package com.frost_fox.jenkins.job_addon.description;

import com.frost_fox.jenkins.job_addon.jenkins.JenkinsJobRepository;
import com.frost_fox.jenkins.job_addon.jenkins.NoSuchJob;
import hudson.model.Result;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;

public class XStreamBuildInfoRepository implements BuildInfoRepository {

    private JenkinsJobRepository jenkinsJobRepository;

    public XStreamBuildInfoRepository(JenkinsJobRepository jenkinsJobRepository) {
        this.jenkinsJobRepository = jenkinsJobRepository;
    }

    @Override
    public BuildInfo getByJobAndBuildId(String jobId, String buildId) throws NoSuchBuild {
        try {
            WorkflowRun run = jenkinsJobRepository.getJob(jobId).getBuildByNumber(Integer.parseInt(buildId));
            if (run == null) {
                throw new NoSuchBuild();
            }
            return new BuildInfo(BuildStatus.from(isSuccess(run), run.isBuilding()),
                    run.getDuration());
        } catch (NoSuchJob e) {
            throw new NoSuchBuild();
        }
    }

    private boolean isSuccess(WorkflowRun run) {
        Result result = run.getResult();
        if (result == null){
            return false;
        }
        return result.toString().equals("SUCCESS");
    }
}
