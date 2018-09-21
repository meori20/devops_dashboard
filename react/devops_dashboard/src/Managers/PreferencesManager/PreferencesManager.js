
export class PreferencesManager {

    constructor(env) {
        this.env = env;
        this.version = '1.0';

        this._REQUEST_INIT_SCREEN = "/getInitialScreen";
        this._REQUEST_BUILD_STREAM = "/subscribeBuild";
        this._REQUEST_RUNNING_BUILD = "/job/{0}/wfapi/runs";
        // this._REQUEST_RUNNING_BUILD = "/jobs/{0}/wfapi/runs";
    }

    getSubscribeBuildURL(){
        return this.env._envConfig.baseURL + this._REQUEST_INIT_SCREEN;
    }

    getStreamURL(){
        return this.env._envConfig.baseURL + this._REQUEST_BUILD_STREAM;
    }

    getAuthorization() {
        return this.env._envConfig.authentication;
    }

    getLastBuildURL() {
        return this.env._envConfig.jenkinsURL + this._REQUEST_RUNNING_BUILD;
    }
}