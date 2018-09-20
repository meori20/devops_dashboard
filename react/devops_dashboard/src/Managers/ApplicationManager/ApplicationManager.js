import HttpClient from "../../Utils/HttpClient";
import {PreferencesManager} from "../PreferencesManager/PreferencesManager";
import {Environment} from "../PreferencesManager/Environment";

class ApplicationManager {

    constructor() {
        if (!global.instance) {
            this.preferencesManager = new PreferencesManager(new Environment());
            this.MainScreenClient = new HttpClient(5000, this.preferencesManager.getBuildURL(), new Headers());
            global.instance = this;
        }
        return global.instance;
    };
}

export let applicationManager = new ApplicationManager();