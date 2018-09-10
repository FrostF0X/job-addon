import Result from "../Result";

export default class StaticAddonExecutor {

    // noinspection JSMethodCanBeStatic
    /**
     * @param url
     * @returns {Result}
     */
    execute(url) {
        return Result.successful("id");
    }

}