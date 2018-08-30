import React, {Component} from 'react';
import './App.css';
import Grid from "./grid/Grid";
import Job from "./job/Job";
import JobDescriptionLoader from "./job/integration/JobDescriptionLoader";
import Environment from "./Environment";
import {alignWithStageViewPlugin} from "./StagePluginIntegration";

export default class App extends Component {
    constructor() {
        super();
        this.environment = determineEnvironment();
        this.jobDescriptionLoader = new JobDescriptionLoader(this.environment);
        alignWithStageViewPlugin(getPlugin());
        this.data = this.jobDescriptionLoader.load();
    }

    render() {
        return (<Grid job={new Job(this.data)}/>);
    }
}

function determineEnvironment() {
    return new Environment(getPlugin().dataset.env);
}

function getPlugin() {
    return document.getElementById('job-addon-grid');
}