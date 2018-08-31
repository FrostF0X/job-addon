import JobFactory from "./JobFactory";

export default class StaticJobDescriptionLoader {
    DESCRIPTION = {
        "buildDescriptions": [{
            "addonExecutions": [{
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-stage"
                }
            }, {
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-prod"
                }
            }], "id": "4"
        }, {
            "addonExecutions": [{
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-stage"
                }
            }, {
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-prod"
                }
            }], "id": "3"
        }, {
            "addonExecutions": [{
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-stage"
                }
            }, {
                "addon": {
                    "name": "Deploy staging",
                    "id": "deploy-prod"
                }
            }], "id": "2"
        }, {
            "addonExecutions": [{
                "addon": {
                    "name": "Old stage",
                    "id": "old-deploy-stage"
                }
            }], "id": "1"
        }]
    };

    async load() {
        return JobFactory.fromResponse(this.DESCRIPTION);
    }
}