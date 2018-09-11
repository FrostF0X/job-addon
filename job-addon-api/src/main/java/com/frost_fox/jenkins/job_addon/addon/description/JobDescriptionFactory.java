package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.AddonContext;
import com.frost_fox.jenkins.job_addon.syntax.AddonContextAction;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecution;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutionFactory;
import com.frost_fox.jenkins.job_addon.addon.execution.JenkinsAddonExecutionManager;
import com.frost_fox.jenkins.job_addon.jenkins.*;

import java.util.ArrayList;
import java.util.List;

public class JobDescriptionFactory {

    private AddonExecutionFactory executionFactory;

    public JobDescriptionFactory(AddonExecutionFactory executionFactory) {
        this.executionFactory = executionFactory;
    }

    public static JobDescriptionFactory get() {
        JenkinsJobRepository repository = new XStreamJenkinsJobRepository();
        return new JobDescriptionFactory(
                new AddonExecutionFactory(new JenkinsAddonExecutionManager(repository), repository)
        );
    }

    public JobDescription create(JenkinsJob job) throws NoSuchJob {
        List<BuildDescription> list = new ArrayList<>();
        for (JenkinsBuild build : job.getBuilds()) {
            BuildDescription description = createDescription(job, build);
            list.add(description);
        }
        return new JobDescription(list, job.getEstimation());
    }

    private BuildDescription createDescription(JenkinsJob job, JenkinsBuild build) throws NoSuchJob {
        List<AddonExecution> executions = new ArrayList<>();

        for (AddonContextAction addonContextAction : build.getAddonActions()) {
            AddonContext context = addonContextAction.getContext();
            AddonExecution execution = executionFactory.create(job, build, context);
            executions.add(execution);
        }

        return new BuildDescription(executions, build.getId());
    }

}
