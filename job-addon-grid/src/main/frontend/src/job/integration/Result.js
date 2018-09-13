export default class Result {

    /**
     * @param {boolean} success
     * @param {any} item
     * @param {string} cause
     */
    constructor(success, item, cause) {
        this.success = success;
        this.item = item;
        this.cause = cause;
    }

    static successful(item) {
        return new Result(true, item, "");
    }

    static failed(cause) {
        return new Result(false, null, cause);
    }

    static fromResponse(response) {
        this.validateStructure(response);
        return new this(response.success, response.item, response.cause);
    }

    static validateStructure(response) {
        if (typeof response.success !== "boolean" || response.item === undefined || typeof response.cause !== "string") {
            throw new Error("unexpected response structure");
        }
    }

    isSuccessful() {
        return this.success;
    }

    get() {
        return this.item;
    }

    getCause() {
        return this.cause;
    }
}