package com.frost_fox.jenkins.job_addon.description;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BuildInfo {

    private final BuildStatus status;
    private final long duration;

    public BuildInfo(BuildStatus status, long duration) {
        this.status = status;
        this.duration = duration;
    }

    public static BuildInfo common() {
        return new BuildInfo(BuildStatus.Success, 0);
    }

    @JsonIgnore
    public BuildStatus getStatus() {
        return status;
    }

    @SuppressWarnings("unused")
    @JsonProperty("status")
    public String getStatusString(){
        return status.toString();
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BuildInfo && o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, duration);
    }
}
