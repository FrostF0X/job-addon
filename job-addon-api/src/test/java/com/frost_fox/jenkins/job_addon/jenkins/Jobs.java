package com.frost_fox.jenkins.job_addon.jenkins;

import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.AddonContexts;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Jobs {

    public static final List<String> BUILD_IDS = Ids.IDS;
    public static final String BUILD_ID = Ids.ID_FROM_IDS;
    public static final List<String> ADDON_IDS = Ids.IDS2;
    public static final String ADDON_ID = Ids.ID_FROM_IDS2;


    public static JenkinsJob jobWithSomeBuildsAndAddonActions() {
        return new JenkinsJob(
                Builds.manyWithIds(BUILD_IDS, Actions.withContexts(AddonContexts.contextsForIds(ADDON_IDS)))
        );
    }


}
