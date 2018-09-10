import React, {Component} from 'react';
import './AddonExecutionView.css';
import EmptyAddonExecution from "../job/EmptyAddonExecution";
import AddonExecuteButton from "./AddonExecuteButton";
import AddonExecution from "../job/AddonExecution";
import PropTypes from 'prop-types';

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
                                <AddonExecuteButton addonExecution={this.props.addonExecution}/>
                            </div>
                        </div>
                    </div>
                </td>);
            }
        })();
    }

    static propTypes = {
        addonExecution: PropTypes.instanceOf(AddonExecution)
    }
}