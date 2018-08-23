package com.frost_fox.jenkins.manual_job;

import hudson.Extension;
import hudson.model.Job;
import hudson.model.Run;
import org.jenkinsci.Symbol;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepDescriptor;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class ManualJobStep extends Step implements Serializable {

    private static final long serialVersionUID = 1;
    private final transient OnDemandJobContext targetJobContext;

    @DataBoundConstructor
    public ManualJobStep(String name, String id) {
        Parameters parameters = new Parameters(name, id);
        targetJobContext = new OnDemandJobContext(parameters.getName(), createExecuteUrl(parameters.getJob()));
    }

    private String createExecuteUrl(Job job) {
        return job.getUrl();
    }

    @Override
    public StepExecution start(StepContext stepContext) throws Exception {
        Run run = Objects.requireNonNull(stepContext.get(Run.class));
        run.addAction(new RunContextAction(targetJobContext));
        return new EmptyStepExecutor(stepContext);
    }

    @Symbol("onDemandJob")
    @Extension
    public static final class Descriptor extends StepDescriptor {
        @Override
        public Set<? extends Class<?>> getRequiredContext() {
            return Collections.emptySet();
        }

        public String getFunctionName() {
            return "onDemandJob";
        }

        public String getDisplayName() {
            return "On Demand Job";
        }

    }
}
