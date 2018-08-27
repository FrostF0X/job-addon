package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.AddonContextAction;
import com.frost_fox.jenkins.job_addon.JobAddonContext;
import com.frost_fox.jenkins.job_addon.jenkins.TestAction;
import hudson.model.Action;

import java.util.Arrays;
import java.util.List;

public class Actions {
    public static List<Action> arbitraryActions() {
        return Arrays.asList(new Action[]{new TestAction(), new TestAction(), new TestAction()});
    }

    public static List<JenkinsAction> addonContextActions() {
        return Arrays.asList(addonContextAction(), addonContextAction(), addonContextAction());
    }

    private static JenkinsAction addonContextAction() {
        return new JenkinsAction(new AddonContextAction(new JobAddonContext("test", "test")));
    }

}
