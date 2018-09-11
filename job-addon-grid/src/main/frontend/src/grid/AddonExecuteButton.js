import React, {Component} from 'react';
import PropTypes from "prop-types";
import AddonExecution from "../job/AddonExecution";
import "./AddonExecuteButton.css";
import AddonExecutor from "../job/integration/executor/AddonExecutor";

export default class AddonExecuteButton extends Component {
    constructor(props) {
        super(props);
        this.props = props;
        this.execute = this.execute.bind(this);
    }

    render() {
        return (
            <button className="job-addon-grid-btn job-addon-grid-btn-sm job-addon-grid-btn-start"
                    onClick={this.execute}>
                Start
            </button>
        )
    }

    async execute() {
        // noinspection JSIgnoredPromiseFromCall
        this.context.executor.execute(this.props.addonExecution);
    }

    static contextTypes = {
        executor: PropTypes.instanceOf(AddonExecutor)
    };

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    }
}