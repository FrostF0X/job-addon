import React, {Component} from 'react';
import './AddonExecutionView.css';

export default class AddonExecutionsView extends Component {
    render() {
        return (
            <td className="job-grid-addon-execution">
                <div className="job-grid-addon-execution-cell-background">
                    <div className="job-grid-addon-execution-cell">
                        <div className="job-grid-addon-execution-content">

                            {this.props.addon.name}
                        </div>
                    </div>
                </div>
            </td>
        )
    }
}