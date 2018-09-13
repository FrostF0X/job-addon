import Result from "../Result";
import JobFactory from "./JobFactory";

export default class JobResult {

    /**
     * @param {object} response
     * @returns {Result}
     */
    static create(response) {
        try {
            return this.createUnsafe(response);
        } catch (e) {
            console.log(e);
            return Result.failed("Response mapping error");
        }
    }

    /**
     * @param {object} response
     * @returns {Result}
     */
    static createUnsafe(response) {
        const result = Result.fromResponse(response);
        if (result.isSuccessful()) {
            return Result.successful(JobFactory.fromResponse(result.get()))
        }
        return result;
    }

}