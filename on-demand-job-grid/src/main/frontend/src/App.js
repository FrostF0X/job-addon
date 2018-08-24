import React, {Component} from 'react';
import './App.css';
import Grid from "./grid/Grid";
import Job from "./job/Job";

export default class App extends Component {
    constructor(){
        super();
        this.data = {
            description: ['Deploy Stage', 'Deploy Prod'],
            executions: [
                ['Deploy Stage', 'Deploy Prod'],
                ['Deploy Stage', 'Deploy Prod']
            ]
        };
    }

    render() {
        return (<Grid job={new Job(this.data)}/>);
    }
}