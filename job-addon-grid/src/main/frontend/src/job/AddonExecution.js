import Addon from "./Addon";

export default class AddonExecution {

    /**
     * @param {Addon} addon
     * @param {string} url
     */
    constructor(addon, url) {
        this.addon = addon;
        this.url = url;
    }

    /**
     * @param {object} object
     * @returns {AddonExecution}
     */
    static fromObject(object) {
        return new this(new Addon(object.addon), object.url);
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

    getId() {
        return this.addon.getId();
    }

    getUrl() {
        return this.url;
    }

    /**
     * @param addon
     * @returns {*}
     */
    ofThat(addon) {
        return this.getAddon().equals(addon);
    }
}