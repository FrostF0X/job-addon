export default class Execution {
    /**
     * @param {AddonExecution[]} addons
     */
    constructor(addons) {
        this.addons = addons;
    }

    /**
     * @returns {AddonExecution[]}
     */
    getAddonExecutions(){
        return this.addons;
    }
}