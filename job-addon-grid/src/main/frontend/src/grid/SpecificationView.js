import React, {Component} from 'react';
import AddonView from "./AddonSpecificationView";
import "./SpecificationView.css";

export default class SpecificationView extends Component {
    render() {
        return (
            <thead>
                <tr className="job-grid-specification">
                    {this.props.specification.getAddons().forEach(addon =>
                        (<AddonView addon={addon}/>)
                    )}
                </tr>
            </thead>
        )
    }
}