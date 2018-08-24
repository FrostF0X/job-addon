import AddonSpecification from "./AddonSpecification";
import Specification from "./Specification";
import Execution from "./Execution";
import AddOnExecution from "./AddonExecution";

export default class JobInfo {
    constructor(info) {
        this.specification = new Specification(info.description.map(name => new AddonSpecification(name)));
        this.executions = info.executions.map(execution => new Execution(execution.map(name => new AddOnExecution(name))));
    }
}