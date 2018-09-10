import JobFactory from "./JobFactory";
import Job from "../../Job";

export default class ApiJobDescriptionLoader {

    /**
     * @param {string} url
     */
    constructor(url) {
        this.url = url;
    }

    /**
     * @returns {object}
     */
    async load() {
        try {
            const response = await fetch(this.url);
            return JobFactory.fromResponse(await response.json());
        } catch (e){
            return Job.default();
        }
    }
}