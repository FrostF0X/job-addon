import Addons from "./Addons";

export default class Specification {

    /**
     * @param {Addons} addons
     */
    constructor(addons) {
        this.addons = addons;
    }

    /**
     * @param {Execution[]} executions
     */
    static fromExecutions(executions) {
        const addons = new Addons();
        executions.forEach(execution => {
                execution.getAddonExecutions().forEach(
                    addonExecution => addons.add(addonExecution.getAddon())
                )
            }
        );
        return new Specification(addons);
    }

    static default(){
        return new Specification(new Addons());
    }

    getAddons() {
        return this.addons;
    }
}