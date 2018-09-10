export default class Result {

    static successful(item) {
        return new this(true, item);
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