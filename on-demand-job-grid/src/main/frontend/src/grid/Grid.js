import React, {Component} from 'react';
import SpecificationView from "./SpecificationView";
import ExecutionsView from "./ExecutionsView";

export default class Grid extends Component {

    constructor(props){
        super(props);
    }

    render() {
        return (
            <div className="job-grid">
                <table className="job-grid-table">
                    <SpecificationView specification={this.props.job.specification}/>
                    <ExecutionsView job={this.props.job}/>
                </table>
            </div>
        );
    }
}