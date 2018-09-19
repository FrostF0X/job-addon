package com.frost_fox.jenkins.job_addon.syntax;

import com.frost_fox.jenkins.job_addon.AddonContext;
import hudson.Extension;
import hudson.model.Run;
import org.jenkinsci.Symbol;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepDescriptor;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class JobAddonStep extends Step implements Serializable {

    private static final long serialVersionUID = 1;
    private final transient AddonContext targetJobContext;

    @DataBoundConstructor
    public JobAddonStep(String name, String id, Map<String, Object> params) {
        Parameters parameters = new Parameters(name, id, params);
        targetJobContext = new AddonContext(parameters.getJob().getName(), parameters.getName(), parameters.getExecutionParameters());
    }

    @Override
    public StepExecution start(StepContext stepContext) throws Exception {
        Run run = Objects.requireNonNull(stepContext.get(Run.class));
        run.addAction(new AddonContextAction(targetJobContext));
        return new EmptyStepExecutor(stepContext);
    }

    @Symbol("jobAddon")
    @Extension
    public static final class Descriptor extends StepDescriptor {
        @Override
        public Set<? extends Class<?>> getRequiredContext() {
            return Collections.emptySet();
        }

        public String getFunctionName() {
            return "jobAddon";
        }

        public String getDisplayName() {
            return "Job Addon";
        }

    }
}
