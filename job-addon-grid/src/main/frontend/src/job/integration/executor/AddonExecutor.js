import StaticAddonExecutor from "./StaticAddonExecutor";
import ApiAddonExecutor from "./ApiAddonExecutor";

export default class AddonExecutor {
    // noinspection JSUnusedLocalSymbols
    /**
     * @param {Environment} environment
     */
    constructor(environment) {
        if (environment.isProd()) {
            this.executor = new ApiAddonExecutor();
        } else {
            this.executor = new StaticAddonExecutor();
        }
    }

    /**
     * @param {AddonExecution} addonExecution
     * @returns {Promise<Result>}
     */
    async execute(addonExecution) {
        return await this.executor.execute(addonExecution);
    }
}