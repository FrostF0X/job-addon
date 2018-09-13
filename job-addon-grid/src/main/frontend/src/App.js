import React, {Component} from 'react';
import './App.css';
import Grid from "./grid/Grid";
import Job from "./job/Job";
import JobDescriptionLoader from "./job/integration/loader/JobDescriptionLoader";
import Environment from "./Environment";
import {alignWithStageViewPlugin} from "./StagePluginIntegration";
import JobDescriptionRefresher from "./job/integration/loader/JobDescriptionRefresher";
import PropTypes from "prop-types";
import AddonExecutor from "./job/integration/executor/AddonExecutor";

export default class App extends Component {
    constructor() {
        super();
        this.createContext();
        this.refresher = new JobDescriptionRefresher(this.appContext.loader, this);
        this.refresher.start();
        alignWithStageViewPlugin(getPlugin());
        this.state = {job: Job.default()};
        this.getChildContext = this.getChildContext.bind(this);
    }

    static childContextTypes = {
        data: PropTypes.object,
        env: PropTypes.instanceOf(Environment),
        executor: PropTypes.instanceOf(AddonExecutor),
        loader: PropTypes.instanceOf(JobDescriptionLoader)
    };

    getChildContext() {
        return this.appContext;
    }

    render() {
        return (<Grid job={this.state.job}/>);
    }

    /**
     * @param {Result} result
     */
    loaded(result) {
        if(result.isSuccessful()) {
            this.setState({job: result.get()});
        } else {
            console.log(result.getCause());
        }
    }

    createContext() {
        this.appContext = {
            data: getEnvSettings(),
        };
        this.appContext.env = determineEnvironment(this.appContext.data);
        this.appContext.loader = new JobDescriptionLoader(this.appContext.env, this.appContext.data);
        this.appContext.executor = new AddonExecutor(this.appContext.env);
    }

}

function determineEnvironment(envSettings) {
    return new Environment(envSettings.env);
}

function getEnvSettings() {
    return getPlugin().dataset;
}

function getPlugin() {
    return document.getElementById('job-addon-grid');
}