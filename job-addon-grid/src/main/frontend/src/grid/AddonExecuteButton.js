import React, {Component} from 'react';
import PropTypes from "prop-types";
import AddonExecution from "../job/AddonExecution";
import "./AddonExecuteButton.css";

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

    execute() {
        console.log(this.props.addonExecution.getUrl());
    }

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    }
}