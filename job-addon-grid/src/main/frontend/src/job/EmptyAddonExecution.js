import AddonExecution from "./AddonExecution";
import Addon from "./Addon";

export default class EmptyAddonExecution extends AddonExecution {
    constructor() {
        super(new Addon({name: "name", id: Math.random().toString(36)}), "url");
    }
}