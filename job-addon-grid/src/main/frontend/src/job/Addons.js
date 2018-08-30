import ComparatorSet from "../SetWithComparator";

export default class Addons extends ComparatorSet {
    constructor() {
        super(comparator, []);
    }
}

function comparator(first, second) {
    return typeof first.equals === "function" && first.equals(second);
}
