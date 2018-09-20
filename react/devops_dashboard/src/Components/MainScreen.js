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
        console.log(this.props.user)
        this.state = {
            user: this.props.user,
            buildHistory: []
        };
        // this.evtSource = new EventSource(applicationManager.preferencesManager.getStreamURL());

        // this.evtSource.onmessage = (e) => {
        //     console.log(e);
        // }
    }

    componentDidMount(){
        applicationManager.MainScreenClient.get().then(response=>{
            this.setState({
                projectList: response.projectList,
            });
        }).catch(error => {
            console.log('this is failing because: ' + error)
        });
        console.log('mounetd');


    }

    displayBuildHistory = (projectName) => {
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
                                    <Pipeline/>
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