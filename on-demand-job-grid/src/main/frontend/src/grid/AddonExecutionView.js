import React, {Component} from 'react';

export default class AddonExecutionsView extends Component {
    render() {
        return (
            <td className="job-grid-row-cell">{this.props.addon.name}</td>
        )
    }
}