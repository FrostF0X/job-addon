export default class ComparatorSet {

    /**
     * @param {function} comparator
     * @param {Array} items
     */
    constructor(comparator, items) {
        this.comparator = comparator;
        this.items = [];
        items.forEach(item => this.add(item));
    }

    has(what) {
        return this.items.some(item => {
            return this.comparator(what, item);
        });
    }

    add(what) {
        if (!this.has(what)) {
            this.items.push(what);
        }
    }

    // noinspection JSUnusedGlobalSymbols
    forEach(callback) {
        this.items.forEach(callback);
    }

    map(callback) {
        return this.items.map(callback);
    }
}