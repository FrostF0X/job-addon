import Result from "../Result";
import JobResult from "./JobResult";

export default class StaticJobDescriptionLoader {
    DESCRIPTION = {
        "success": true,
        "item": {
            "buildDescriptions": [{
                "addonExecutions": [{
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-stage",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }, {
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-prod",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }], "id": "4"
            }, {
                "addonExecutions": [{
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-stage",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }, {
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-prod",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }], "id": "3"
            }, {
                "addonExecutions": [{
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-stage",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }, {
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-prod",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }], "id": "2"
            }, {
                "addonExecutions": [{
                    "addon": {
                        "name": "Old stage",
                        "id": "old-deploy-stage",
                        "estimation": 2113
                    },
                    "url": "http://localhost:3000/test"
                }], "id": "1"
            }]
        },
        "cause": ""
    };

    /**
     * @returns {Promise<Result>}
     */
    async load() {
        return JobResult.create(this.DESCRIPTION);
    }
}