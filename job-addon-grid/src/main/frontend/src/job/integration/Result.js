export default class Result {

    static successful(item) {
        return new this(true, item);
    }

    static failed(item) {
        return new this(false, item);
    }

    static fromResponse(response) {
        if (typeof response.success === "boolean" || response.item === undefined) {
            throw new Error("unexpected response structure");
        }
        return new this(response.success, response.item);
    }

    /**
     * @param {boolean} success
     * @param {any} item
     */
    constructor(success, item) {
        this.success = success;
        this.item = item;
    }

}