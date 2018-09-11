import Result from "../Result";

export default class StaticAddonExecutor {

    // noinspection JSMethodCanBeStatic
    /**
     * @param {AddonExecution} addonExecution
     * @returns {Promise<Result>}
     */
    async execute(addonExecution) {
        return await Result.successful("id");
    }

}