import React, {Component} from 'react';
import './AddonExecutionProgress.css';
import PropTypes from "prop-types";
import AddonExecution from "../job/AddonExecution";
import Status from "../job/Status";

export default class AddonExecutionProgress extends Component {

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    };

    render() {
        if (!this.props.addonExecution.hasStatus(Status.Running)) {
            return "";
        }
        return (
            <div className="job-grid-addon-execution-progress-bar">
                <div className="job-grid-addon-execution-progress" style={this.getWidth()}/>
            </div>
        )
    }

    getWidth() {
        return {"width": this.props.addonExecution.getProgress() + "%"};
    }
}