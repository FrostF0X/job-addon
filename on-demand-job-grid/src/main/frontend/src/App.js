import React, {Component} from 'react';
import './App.css';
import Grid from "./grid/Grid";
import Job from "./job/Job";

export default class App extends Component {
    constructor() {
        super();
        this.data = {
            description: ['Deploy Stage', 'Deploy Prod'],
            executions: [
                ['Deploy Stage', 'Deploy Prod'],
                ['Deploy Stage', 'Deploy Prod']
            ]
        };
        alignWithStageViewPlugin();
    }

    render() {
        return (<Grid job={new Job(this.data)}/>);
    }
}

function appendToStageView() {
    let onDemandJobPlugin = document.getElementById('on-demand-job-grid');
    let stageViewPluginRect = document.querySelector('.table-viewPort').getBoundingClientRect();

    onDemandJobPlugin.style.position = 'fixed';
    onDemandJobPlugin.style.display = 'block';
    onDemandJobPlugin.style.left = stageViewPluginRect.right + 2 + 'px';
    onDemandJobPlugin.style.top = stageViewPluginRect.top + 'px';
}

function alignWithStageViewPlugin() {
    const interval = setInterval(() => {
        try {
            appendToStageView();
            window.addEventListener('scroll', appendToStageView);
            window.addEventListener('resize', appendToStageView);
            clearInterval(interval);
        } catch (e) {
        }
    }, 200);
}