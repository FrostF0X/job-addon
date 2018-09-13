import Result from "../Result";
import JobResult from "./JobResult";

export default class ApiJobDescriptionLoader {

    /**
     * @param {string} url
     */
    constructor(url) {
        this.url = url;
    }

    /**
     * @returns {Promise<Result>}
     */
    async load() {
        try {
            const response = await fetch(this.url);
            return JobResult.create(await response.json());
        } catch (e){
            return Result.failed("Unexpected api error");
        }
    }
}