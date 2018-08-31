import React, {Component} from 'react';
import AddonExecutionView from "./AddonExecutionView";
import './ExecutionView.css';

export default class ExecutionView extends Component {
    render() {
        return (
            <tbody>
            <tr className="job-grid-execution">
                {this.props.execution.getAddonExecutions()
                    .map(addonExecution =>
                        <AddonExecutionView key={addonExecution.getId()} addonExecution={addonExecution}/>)
                }
            </tr>
            </tbody>
        )
    }
}