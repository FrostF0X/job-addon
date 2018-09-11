export default class Addon {
    constructor(info) {
        this.name = info.name;
        this.id = info.id;
        this.estimation = info.estimation;
    }

    /**
     * @returns {string}
     */
    getName() {
        return this.name;
    }

    /**
     * @returns {string}
     */
    getId() {
        return this.id;
    }

    /**
     * @param comparable
     * @returns {boolean}
     */
    equals(comparable){
        return comparable instanceof Addon &&
            this.name === comparable.name &&
            this.id === comparable.id;
    }
}