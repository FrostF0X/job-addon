import React, {Component} from 'react';
import './AddonSpecificationView.css';

export default class AddonSpecificationView extends Component {
    render() {
        return (
            <th className="job-grid-addon-specification">{this.props.addon.name}</th>
        );
    }
}
