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

    getId() {
        return this.id;
    }
}