export default class JobDescriptionRefresher {

    REFRESH_INTERVAL = 1000;

    /**
     * @param {JobDescriptionLoader} loader
     * @param {App} receiver
     */
    constructor(loader, receiver) {
        this.loader = loader;
        this.receiver = receiver;
    }

    start() {
        setInterval(async () => {
            this.receiver.loaded(await this.loader.load());
        }, this.REFRESH_INTERVAL);
    }

}