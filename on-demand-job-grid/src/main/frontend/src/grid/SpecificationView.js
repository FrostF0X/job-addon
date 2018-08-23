import React, {Component} from 'react';
import AddonSpecificationView from "./AddonSpecificationView";

export default class SpecificationView extends Component {
    render() {
        return (

            <tr className="job-grid-specification">
                {this.props.specification.addons.map(addon =>
                    (<AddonSpecificationView addon={addon}/>)
                )}
            </tr>
        )
    }
}