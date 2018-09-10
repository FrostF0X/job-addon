import StaticAddonExecutor from "./StaticAddonExecutor";

export default class AddonExecutor {
    // noinspection JSUnusedLocalSymbols
    constructor(environment) {
        this.executor = new StaticAddonExecutor();
    }

    /**
     * @param url
     * @returns {Result}
     */
    execute(url){
        return this.executor.execute(url);
    }
}