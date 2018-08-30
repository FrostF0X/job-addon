import JobFactory from "./JobFactory";

export default class StaticJobDescriptionLoader {
    DESCRIPTION = {
        "buildDescriptions": [
            {
                "addonExecutions": [
                    {
                        "addon": {
                            "name": "Deploy staging",
                            "id": "deploy-stage"
                        }
                    },
                    {
                        "addon": {
                            "name": "Deploy prod",
                            "id": "deploy-prod"
                        }
                    }
                ],
                "id": "2"
            },
            {
                "addonExecutions": [
                    {
                        "addon": {
                            "name": "Deploy staging",
                            "id": "deploy-stage"
                        }
                    },
                    {
                        "addon": {
                            "name": "Deploy prod",
                            "id": "deploy-prod"
                        }
                    }
                ],
                "id": "1"
            }
        ]
    };

    load() {
        return JobFactory.fromResponse(this.DESCRIPTION);
    }
}