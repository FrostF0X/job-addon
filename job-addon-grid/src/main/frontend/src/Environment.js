export default class Environment {
    DEV = 'dev';

    /**
     * @param {string} plainValue
     */
    constructor(plainValue) {
        this.prod = plainValue !== this.DEV;
    }

    // noinspection JSUnusedGlobalSymbols
    isProd() {
        return this.prod;
    }

    // noinspection JSUnusedGlobalSymbols
    isDev() {
        return !this.prod;
    }
}