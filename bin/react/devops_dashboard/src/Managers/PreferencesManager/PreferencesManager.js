
export class PreferencesManager {

    constructor(env) {
        this.env = env;
        this.version = '1.0';

        this._REQUEST_INIT_SCREEN = "/getInitialScreen";
        this._REQUEST_BUILD_STREAM = "/subscribeBuild";
    }

    getBuildURL(){
        return this.env._envConfig.baseURL + this._REQUEST_INIT_SCREEN;
    }

    getStreamURL(){
        return this.env._envConfig.baseURL + this._REQUEST_BUILD_STREAM;
    }

}