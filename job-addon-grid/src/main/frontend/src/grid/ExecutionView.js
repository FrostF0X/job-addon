import React, {Component} from 'react';
import AddonExecutionView from "./AddonExecutionView";
import './ExecutionView.css';

export default class ExecutionView extends Component {
    render() {
        return (
            <tr className="job-grid-execution">
                {this.props.execution.getAddonExecutionsBySpecification(this.props.specification)
                    .map(addonExecution =>
                        <AddonExecutionView key={addonExecution.getId()} addonExecution={addonExecution}/>)
                }
            </tr>
        )
    }
}