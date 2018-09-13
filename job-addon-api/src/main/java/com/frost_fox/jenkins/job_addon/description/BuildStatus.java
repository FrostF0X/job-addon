package com.frost_fox.jenkins.job_addon.description;

public enum BuildStatus {
    Running("running"),
    Fail("fail"),
    Success("success");

    private String stringRepresentation;

    BuildStatus(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static BuildStatus from(boolean success, boolean isBuilding) {
        if (isBuilding) {
            return Running;
        } else if (success) {
            return Success;
        }
        return Fail;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }

}
