import Result from "../Result";

export default class ApiAddonExecutor {
    // noinspection JSMethodCanBeStatic
    /**
     * @param {AddonExecution} addonExecution
     * @returns {Promise<Result>}
     */
    async execute(addonExecution) {
        try {
            const response = await fetch(addonExecution.getUrl());
            return Result.fromResponse(await response.json());
        } catch (e){
            return Result.failed("Unexpected response");
        }
    }
}