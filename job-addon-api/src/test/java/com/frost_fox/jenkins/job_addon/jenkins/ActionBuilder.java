package com.frost_fox.jenkins.job_addon.jenkins;

import hudson.model.Action;

import java.util.List;

public interface ActionBuilder {

    List<Action> create();

}
