package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.model.Job;
import org.jenkinsci.Symbol;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
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
    private final transient ManualJobContext targetJobContext;

    @DataBoundConstructor
    public ManualJobStep(String name, String id) {
        Parameters parameters = new Parameters(name, id);
        targetJobContext = new ManualJobContext(parameters.getName(), createExecuteUrl(parameters.getJob()));
    }

    private String createExecuteUrl(Job job) {
        return job.getUrl() + "/build";
    }

    @Override
    public StepExecution start(StepContext stepContext) throws Exception {
        FlowNode node = Objects.requireNonNull(stepContext.get(FlowNode.class));
        node.addAction(new NodeContextAction(targetJobContext));
        return new EmptyStepExecutor(stepContext);
    }

    @Symbol("manualJob")
    @Extension
    public static final class Descriptor extends StepDescriptor {
        @Override
        public Set<? extends Class<?>> getRequiredContext() {
            return Collections.emptySet();
        }

        public String getFunctionName() {
            return "manualJob";
        }

        public String getDisplayName() {
            return "Manual Job";
        }

    }
}
