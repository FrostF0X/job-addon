package com.frost_fox.jenkins.job_addon.addon.description;

import com.frost_fox.jenkins.job_addon.Ids;
import com.frost_fox.jenkins.job_addon.addon.execution.AddonExecutions;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class JobDescriptions {

    public static final List<String> BUILD_IDS = Ids.IDS;
    public static final String BUILD_ID = Ids.ID_FROM_IDS;
    public static final String NO_SUCH_BUILD_ID = Ids.ID_NOT_FROM_IDS;
    public static final List<String> ADDON_IDS = Ids.IDS2;
    public static final String ADDON_ID = Ids.ID_FROM_IDS2;

    public static JobDescription withSomeBuildsAndAddons() {
        return new JobDescription(BuildDescriptions.manyWithIds(BUILD_IDS, AddonExecutions.forIds(ADDON_IDS)));
    }

}
