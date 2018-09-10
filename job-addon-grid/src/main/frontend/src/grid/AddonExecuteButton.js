import React, {Component} from 'react';
import PropTypes from "prop-types";
import AddonExecution from "../job/AddonExecution";

export default class AddonExecuteButton extends Component {
    constructor(props){
        super(props);
        this.props = props;
        this.execute = this.execute.bind(this);
    }
    render() {
        return (
            <button onClick={this.execute}>
                {this.props.addonExecution.getName()}
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