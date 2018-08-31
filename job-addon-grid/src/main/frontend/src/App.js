import React, {Component} from 'react';
import './App.css';
import Grid from "./grid/Grid";
import Job from "./job/Job";
import JobDescriptionLoader from "./job/integration/JobDescriptionLoader";
import Environment from "./Environment";
import {alignWithStageViewPlugin} from "./StagePluginIntegration";
import JobDescriptionRefresher from "./job/integration/JobDescriptionRefresher";

export default class App extends Component {
    constructor() {
        super();
        this.environment = determineEnvironment();
        this.loader = new JobDescriptionLoader(this.environment);
        this.refresher = new JobDescriptionRefresher(this.loader, this);
        this.refresher.start();
        alignWithStageViewPlugin(getPlugin());
        this.state = {job: Job.default()};
    }

    render() {
        return (<Grid job={this.state.job}/>);
    }

    /**
     * @param {Job} job
     */
    loaded(job) {
        this.setState({job: job});
    }
}

function determineEnvironment() {
    return new Environment(getPlugin().dataset.env);
}

function getPlugin() {
    return document.getElementById('job-addon-grid');
}