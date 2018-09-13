import React, {Component} from 'react';
import AddonExecuteButton from "./AddonExecuteButton";
import AddonExecution from "../job/AddonExecution";
import PropTypes from 'prop-types';
import "./AddonExecutionCell.css";
import Status from "../job/Status";
import AddonExecutionProgress from "./AddonExecutionProgress";

export default class AddonExecutionCell extends Component {
    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    };
    static background = "job-grid-addon-execution-cell-background ";
    static success = "job-grid-addon-execution-cell-success ";
    static fail = "job-grid-addon-execution-cell-fail ";
    static running = "job-grid-addon-execution-cell-running ";

    render() {
        return (
            <div className={this.getClass()}>
                <div className="job-grid-addon-execution-cell">
                    <div className="job-grid-addon-execution-content">
                        <AddonExecutionProgress addonExecution={this.props.addonExecution}/>
                        <AddonExecuteButton addonExecution={this.props.addonExecution}/>
                    </div>
                </div>
            </div>
        );
    }

    getClass() {
        if (this.hasStatus(Status.Fail)) {
            return AddonExecutionCell.background + AddonExecutionCell.fail;
        } else if (this.hasStatus(Status.Success)) {
            return AddonExecutionCell.background + AddonExecutionCell.success;
        } else if (this.hasStatus(Status.Running)) {
            return AddonExecutionCell.background + AddonExecutionCell.running;
        }
        return AddonExecutionCell.background;
    }

    /**
     * @param {string} status
     * @returns {boolean}
     */
    hasStatus(status) {
        return this.props.addonExecution.hasStatus(status);
    }

}