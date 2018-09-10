import React, {Component} from 'react';
import './AddonExecutionView.css';
import EmptyAddonExecution from "../job/EmptyAddonExecution";
import AddonExecution from "../job/AddonExecution";
import PropTypes from 'prop-types';
import AddonExecutionCell from "./AddonExecutionCell";

export default class AddonExecutionView extends Component {
    render() {
        return (() => {
            if (this.props.addonExecution instanceof EmptyAddonExecution) {
                return (<td className="job-grid-addon-execution"/>);
            } else {
                return (<td className="job-grid-addon-execution">
                    <AddonExecutionCell addonExecution={this.props.addonExecution}/>
                </td>);
            }
        })();
    }

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    }
}