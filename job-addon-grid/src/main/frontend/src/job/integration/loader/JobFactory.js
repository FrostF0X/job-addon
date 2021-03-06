import Execution from "../../Execution";
import Specification from "../../Specification";
import AddonExecution from "../../AddonExecution";
import Job from "../../Job";

export default class JobFactory {

    /**
     * @param {object} response
     * @returns {Job}
     */
    static fromResponse(response) {
        const executions = response.buildDescriptions.map(execution => {
            return new Execution(execution.id, execution.addonExecutions.map(info => AddonExecution.fromObject(info)));
        });
        const specification = Specification.fromExecutions(executions);
        return new Job(specification, executions);
    }
}