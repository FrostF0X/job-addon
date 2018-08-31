import Addon from "./Addon";

export default class AddonExecution {

    /**
     * @param {Addon} addon
     */
    constructor(addon) {
        this.addon = addon;
    }

    /**
     * @param {object} object
     * @returns {AddonExecution}
     */
    static fromObject(object){
        return new this(new Addon(object.addon));
    }

    /**
     * @returns {Addon}
     */
    getAddon() {
        return this.addon;
    }

    getName() {
        return this.addon.getName();
    }

    /**
     * @param addon
     * @returns {*}
     */
    ofThat(addon) {
        return this.getAddon().equals(addon);
    }

    getId() {
        return this.addon.getId();
    }
}