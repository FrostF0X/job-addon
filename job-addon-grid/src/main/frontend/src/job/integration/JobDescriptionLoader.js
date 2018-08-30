export default class JobDescriptionLoader {

    constructor() {
        this.data = {
            description: ['Deploy Stage', 'Deploy Prod'],
            executions: [
                ['Deploy Stage', 'Deploy Prod'],
                ['Deploy Stage', 'Deploy Prod']
            ]
        };
    }

    load() {
        return this.data;
    }

}