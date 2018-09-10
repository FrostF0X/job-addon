import React, {Component} from 'react';
import AddonExecuteButton from "./AddonExecuteButton";
import AddonExecution from "../job/AddonExecution";
import PropTypes from 'prop-types';
import "./AddonExecutionCell.css";

export default class AddonExecutionCell extends Component {
    render() {
        return (
            <div className="job-grid-addon-execution-cell-background">
                <div className="job-grid-addon-execution-cell">
                    <div className="job-grid-addon-execution-content">
                        <AddonExecuteButton addonExecution={this.props.addonExecution}/>
                    </div>
                </div>
            </div>
        );
    }

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    }
}