import StaticJobDescriptionLoader from "./StaticJobDescriptionLoader";

export default class JobDescriptionLoader {

    constructor() {
        this.loader = new StaticJobDescriptionLoader();
    }

    load() {
        return this.loader.load();
    }

}