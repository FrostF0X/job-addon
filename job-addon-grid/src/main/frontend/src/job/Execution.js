import EmptyAddonExecution from "./EmptyAddonExecution";

export default class Execution {
    /**
     * @param {string} id
     * @param {AddonExecution[]} addons
     */
    constructor(id, addons) {
        this.id = id;
        this.addons = addons;
    }

    /**
     * @returns {AddonExecution[]}
     */
    getAddonExecutions() {
        return this.addons;
    }

    /**
     * @param {Specification} specification
     */
    getAddonExecutionsBySpecification(specification) {
        return specification.getAddons().map(addon => {
            return this.getAddonExecutionByAddon(addon) || new EmptyAddonExecution(addon);
        });
    }

    getAddonExecutionByAddon(addon) {
        return this.getAddonExecutions().find(execution => execution.ofThat(addon));
    }

    getId() {
        return this.id;
    }
}