package com.frost_fox.jenkins.job_addon.description;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuildStatusTest {

    @Test
    public void returnsRunningStatusIfIsBuildingIsTrue() {
        BuildStatus status = BuildStatus.from(true, true);

        assertThat(status).isEqualTo(BuildStatus.Running);
    }

    @Test
    public void returnsSuccessStatusIfIsBuildingIsFalseAndSuccessIsTrue() {
        BuildStatus status = BuildStatus.from(true, false);

        assertThat(status).isEqualTo(BuildStatus.Success);
    }

    @Test
    public void returnsFailStatusIfIsBuildingIsFalseAndSuccessIsFalse() {
        BuildStatus status = BuildStatus.from(false, false);

        assertThat(status).isEqualTo(BuildStatus.Fail);
    }



}