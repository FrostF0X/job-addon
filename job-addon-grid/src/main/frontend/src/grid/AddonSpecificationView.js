import React, {Component} from 'react';
import './AddonSpecificationView.css';

export default class AddonSpecificationView extends Component {
    render() {
        return (
            <th className="job-grid-addon-specification">
                <div className="job-grid-addon-specification-description">
                    {this.props.addon.getName()}
                </div>
                <div className="job-grid-addon-specification-estimation">
                    <h5 className="job-grid-addon-specification-estimation-label">20ms</h5>
                </div>
            </th>
        );
    }
}
