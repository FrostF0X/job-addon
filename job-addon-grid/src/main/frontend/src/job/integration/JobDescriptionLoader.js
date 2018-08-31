import StaticJobDescriptionLoader from "./StaticJobDescriptionLoader";
import ApiJobDescriptionLoader from "./ApiJobDescriptionLoader";

export default class JobDescriptionLoader {

    /**
     * @param {Environment} environment
     * @param {object} envSettings
     */
    constructor(environment, envSettings) {
        if(environment.isDev()) {
            this.loader = new StaticJobDescriptionLoader();
        } else {
            this.loader = new ApiJobDescriptionLoader(envSettings.url);
        }
    }

    async load() {
        return await this.loader.load();
    }

}