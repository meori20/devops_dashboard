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
                    this.getLastBuild(projectName);
                    this.intervalOn = true;
                }
            }
        }
    }

    componentDidMount(){
        applicationManager.MainScreenClient.get().then(response=>{
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

    getLastBuild = (projectName) => {
        //TODO: popup massage that will inform about new build in project
        applicationManager.LastBuildClient.resetURL();
        applicationManager.LastBuildClient._urlWithParams = applicationManager.LastBuildClient._urlWithParams.formatString(projectName);
        applicationManager.LastBuildClient.get().then(response => {
            console.log(response[0].stages);
            this.setState({
                lastBuildStages: response[0].stages,
                ableToLoadPipeLine: true
            })
        }).catch(error => {
            this.setState({
                ableToLoadPipeline: false
            })
        });
    };

    displayBuildHistory = (projectName) => {
        applicationManager.sessionManager.projectName = projectName;
        this.getLastBuild(applicationManager.sessionManager.projectName);
        this.setState({
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
                                <ProjectPanel projectList={this.state.projectList} callback={this.displayBuildHistory}/>
                                <div className='all-statistic-container'>
                                    <Pipeline stages={this.state.lastBuildStages} ableToLoadPipeLine={this.state.ableToLoadPipeLine}/>
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