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
        setInterval(() => {
            this.receiver.loaded(this.loader.load());
            console.log('loaded');
        }, this.REFRESH_INTERVAL);
    }

}