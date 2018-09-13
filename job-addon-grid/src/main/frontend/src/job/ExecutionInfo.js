import Status from './Status';

export default class ExecutionInfo {
    /**
     * @param {string} status
     * @param {int} duration
     */
    constructor(status, duration) {
        this.status = status;
        this.duration = duration;
    }


    static fromObject(object) {
        return new ExecutionInfo(Status.fromPlain(object.status), object.duration);
    }

    /**
     * @returns {string}
     */
    getStatus() {
        return this.status;
    }

    /**
     * @returns {int}
     */
    getDuration() {
        return this.duration;
    }
}