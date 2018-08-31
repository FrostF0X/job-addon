export default class Addon {
    constructor(info) {
        this.name = info.name;
        this.id = info.id;
    }

    getName() {
        return this.name;
    }

    getId() {
        return this.id;
    }

    equals(comparable){
        return comparable instanceof Addon &&
            this.name === comparable.name &&
            this.id === comparable.id;
    }
}