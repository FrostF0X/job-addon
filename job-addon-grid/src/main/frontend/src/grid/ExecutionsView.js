import React, {Component} from 'react';
import ExecutionView from "./ExecutionView";

export default class ExecutionsView extends Component {
    render() {
        return (
            <tbody>
            {this.props.job.getExecutions().map(execution =>
                (<ExecutionView key={execution.getId()}
                                specification={this.props.job.getSpecification()}
                                execution={execution}/>))
            }
            </tbody>
        )
    }
}