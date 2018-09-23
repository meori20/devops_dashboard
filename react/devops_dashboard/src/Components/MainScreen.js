import React, { Component } from 'react';
import PropTypes from 'prop-types';
import "../css/MainSecreen.css";
import Pipeline from "./Pipeline";
import Statistics from "./Statistics";
import MemberInfoAndControl from "./MemberInfoAndControl";
import Tabs from "./Tabs";
import BuildHistory from "./BuildHistory";
import ProjectPanel from "./ProjectPanel";
import {applicationManager} from "../Managers/ApplicationManager/ApplicationManager";
import {BuildStatus} from "../Utils/AppEnums";

class MainScreen extends Component {
    constructor(props) {
        super(props);
        this.state={
            user: props.user,
        };
        this.intervalOn = false;
        this.firstReload = true;
        this.evtSource = new EventSource(applicationManager.preferencesManager.getStreamURL());
        this.evtSource.onmessage = (e) => {
            let data = e.data;
            let projectName = data.split(';')[0].split('/')[2];
            if(projectName){
                projectName = projectName.substring(0,projectName.length - 1);
                if(!this.intervalOn){
                    this.getLastBuildInterval(projectName);
                    this.intervalOn = true;
                }
            }
        };
    }


    async componentDidMount(){
        // await applicationManager.preferencesManager.updateConfigurations();
        await applicationManager.preferencesManager.updateConfigurations();
        await applicationManager.MainScreenClient.get().then(response=>{
            if(this.firstReload){
                applicationManager.sessionManager.projectList = response.projectList;
                applicationManager.sessionManager.projectName = Object.keys(response.projectList)[0];
                applicationManager.sessionManager.buildHistory = Object.values(response.projectList)[0].buildList;
                this.setState({
                    projectList: response.projectList,
                    projectName: Object.keys(response.projectList)[0],
                    buildHistory: Object.values(response.projectList)[0].buildList
                });
                this.firstReload = false;
            }else{
                this.setState(state => {
                    return {
                        projectList: response.projectList,
                        buildHistory: response.projectList[state.projectName].buildList
                }});
            }
            // this.interval = setInterval(this.getLastBuild.bind(this), 1000);
        }).catch(error => {
            console.log('this is failing because: ' + error)
        });

    }

    getLastBuildInterval = (projectName) => {
        this.interval = setInterval(()=>{
            this.getLastBuild(projectName)}
            , 1000)
    };

    getLastBuild = (buildProjectName) => {
        //TODO: popup massage that will inform about new build in project
        //TODO: Check if build is done and clear interval
        applicationManager.LastBuildClient.resetURL();
        applicationManager.LastBuildClient._urlWithParams = applicationManager.LastBuildClient._urlWithParams.formatString(buildProjectName);
        applicationManager.LastBuildClient.get().then(response => {
            if(this.checkIntervalStatus(response[0].stages) && this.intervalOn){
                clearInterval(this.interval);
                this.intervalOn = false;
            };
            console.log('setting to true');
            this.setState({
                lastBuildStages: response[0].stages,
                ableToLoadPipeline: this.checkIfPipelineEnable(buildProjectName)
            })
        }).catch(error => {
            console.log('setting to false');
            this.setState({
                lastBuildStages: [],
                ableToLoadPipeline: false
            })
        });
    };

    checkIntervalStatus(stages){
        console.log('consoliing stages: '  + JSON.stringify(stages));
        let result = true;
        stages.forEach(stage =>{
            if(stage.status !== BuildStatus.success)
                result = false;
        });
        console.log('returning ' + result);
        return result;
    }

    checkIfPipelineEnable = (buildProjectName) =>{
        console.log(buildProjectName,this.state.projectName);
        if(buildProjectName === this.state.projectName){
            return true;
        }
    };

    async displayBuildHistory(projectName){
        applicationManager.sessionManager.projectName = projectName;
        await this.getLastBuild(applicationManager.sessionManager.projectName);
        await this.setState({
            projectName: projectName,
            buildHistory: this.state.projectList[projectName].buildList
        })
    };


    render() {
        return (
            <div className="limiter">
                <div className="container-main-screen100">
                    <div className="wrap-main-screen100">
                        <MemberInfoAndControl name={this.state.user.name} jobTitle={this.state.user.jobTitle}/>
                        <Tabs/>
                        <div className='main-panel-container'>
                            <BuildHistory buildHistoryList={this.state.buildHistory} projectName={this.state.projectName}/>
                            <div className='project-panel-container'>
                                <ProjectPanel projectList={this.state.projectList} callback={this.displayBuildHistory.bind(this)}/>
                                <div className='all-statistic-container'>
                                    <Pipeline stages={this.state.lastBuildStages} ableToLoadPipeline={this.state.ableToLoadPipeline}/>
                                    <Statistics/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

MainScreen.propTypes = {
    user: PropTypes.object,
};

export default MainScreen;