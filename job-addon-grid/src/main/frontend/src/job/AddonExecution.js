import Addon from "./Addon";
import ExecutionInfo from "./ExecutionInfo";
import Count from "../Count";

export default class AddonExecution {

    /**
     * @param {Addon} addon
     * @param {ExecutionInfo} executionInfo
     * @param {string} url
     */
    constructor(addon, executionInfo, url) {
        this.addon = addon;
        this.executionInfo = executionInfo;
        this.url = url;
    }

    /**
     * @param {object} object
     * @returns {AddonExecution}
     */
    static fromObject(object) {
        return new this(new Addon(object.addon), ExecutionInfo.fromObject(object.lastBuildInfo), object.url);
    }

    /**
     * @returns {Addon}
     */
    getAddon() {
        return this.addon;
    }

    /**
     * @returns {string}
     */
    getName() {
        return this.addon.getName();
    }

    /**
     * @returns {string}
     */
    getId() {
        return this.addon.getId();
    }

    /**
     * @returns {string}
     */
    getUrl() {
        return this.url;
    }

    /**
     * @param {string} status
     * @return {boolean}
     */
    hasStatus(status) {
        return this.getExecutionInfo().getStatus() === status;
    }

    /**
     * @returns {ExecutionInfo}
     */
    getExecutionInfo() {
        return this.executionInfo;
    }

    /**
     * @return {number}
     */
    getProgress() {
        return Math.min(Count.inPercents(this.getExecutionInfo().getDuration() / this.getAddon().getEstimation()), 100);
    }

    /**
     * @param addon
     * @returns {*}
     */
    ofThat(addon) {
        return this.getAddon().equals(addon);
    }
}