import React, {Component} from 'react';
import ExecutionView from "./ExecutionView";

export default class ExecutionsView extends Component {
    render() {
        return this.props.job.executions.map(execution =>
            (<ExecutionView execution={execution}/>)
        )
    }
}