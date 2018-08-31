import React, {Component} from 'react';
import './AddonExecutionView.css';

export default class AddonExecutionView extends Component {
    render() {
        return (
            <td className="job-grid-addon-execution">
                <div className="job-grid-addon-execution-cell-background">
                    <div className="job-grid-addon-execution-cell">
                        <div className="job-grid-addon-execution-content">
                            {this.props.addonExecution.getName()}
                        </div>
                    </div>
                </div>
            </td>
        )
    }
}