import React, {Component} from 'react';
import './AddonExecutionView.css';
import EmptyAddonExecution from "../job/EmptyAddonExecution";

export default class AddonExecutionView extends Component {
    render() {
        return (() => {
            if (this.props.addonExecution instanceof EmptyAddonExecution) {
                return (<td className="job-grid-addon-execution"/>);
            } else {
                return (<td className="job-grid-addon-execution">
                    <div className="job-grid-addon-execution-cell-background">
                        <div className="job-grid-addon-execution-cell">
                            <div className="job-grid-addon-execution-content">
                                {this.props.addonExecution.getName()}
                            </div>
                        </div>
                    </div>
                </td>);
            }
        })();
    }
}