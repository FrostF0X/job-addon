import React, {Component} from 'react';
import AddonExecuteButton from "./AddonExecuteButton";
import AddonExecution from "../job/AddonExecution";
import PropTypes from 'prop-types';
import "./AddonExecutionCell.css";
import Status from "../job/Status";

export default class AddonExecutionCell extends Component {
    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    };
    static background = "job-grid-addon-execution-cell-background ";
    static success = "job-grid-addon-execution-cell-success ";
    static fail = "job-grid-addon-execution-cell-fail ";

    render() {
        return (
            <div className={this.getClass()}>
                <div className="job-grid-addon-execution-cell">
                    <div className="job-grid-addon-execution-content">
                        <AddonExecuteButton addonExecution={this.props.addonExecution}/>
                    </div>
                </div>
            </div>
        );
    }

    getClass() {
        if (this.props.addonExecution.getExecutionInfo().getStatus() === Status.Fail) {
            return AddonExecutionCell.background + AddonExecutionCell.fail;
        } else if (this.props.addonExecution.getExecutionInfo().getStatus() === Status.Success) {
            return AddonExecutionCell.background + AddonExecutionCell.success;
        }
    }
}