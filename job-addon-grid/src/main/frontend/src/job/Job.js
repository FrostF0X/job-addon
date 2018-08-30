import Specification from "./Specification";
import Execution from "./Execution";

export default class Job {

    /**
     * @param {Specification} specification
     * @param {Execution[]} executions
     */
    constructor(specification, executions) {
        this.specification = specification;
        this.executions = executions;
    }

    static default() {
        return new Job(Specification.default(), []);
    }

    getExecutions() {
        return this.executions;
    }

    // noinspection JSUnusedGlobalSymbols
    getSpecification() {
        return this.specification;
    }
}