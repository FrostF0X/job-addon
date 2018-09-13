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
                    "lastBuildInfo": {
                        "duration": 27,
                        "status": "success"
                    },
                    "url": "http://localhost:3000/test"
                }, {
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-prod",
                        "estimation": 2113
                    },
                    "lastBuildInfo": {
                        "duration": 27,
                        "status": "fail"
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
                    "lastBuildInfo": {
                        "duration": 1000,
                        "status": "running"
                    },
                    "url": "http://localhost:3000/test"
                }, {
                    "addon": {
                        "name": "Deploy staging",
                        "id": "deploy-prod",
                        "estimation": 2113
                    },
                    "lastBuildInfo": {
                        "duration": 27,
                        "status": "fail"
                    },
                    "url": "http://localhost:3000/test"
                }], "id": "3"
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