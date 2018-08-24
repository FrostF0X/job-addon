import React, {Component} from 'react';
import AddonSpecificationView from "./AddonSpecificationView";
import "./SpecificationView.css";

export default class SpecificationView extends Component {
    render() {
        return (
            <thead>
                <tr className="job-grid-specification">
                    {this.props.specification.addons.map(addon =>
                        (<AddonSpecificationView addon={addon}/>)
                    )}
                </tr>
            </thead>
        )
    }
}