import React, {Component} from 'react';
import AddonExecutionView from "./AddonExecutionView";

export default class ExecutionView extends Component {
    render() {
        return (
            <tr className="job-grid-row">
                {this.props.execution.addons.map(addon => <AddonExecutionView addon={addon}/>)}
            </tr>
        )
    }
}