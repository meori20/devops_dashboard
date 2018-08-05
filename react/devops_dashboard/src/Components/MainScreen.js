import React, { Component } from 'react';
import PropTypes from 'prop-types';
import "../css/MainSecreen.css";
import Pipeline from "./Pipeline";
import Statistics from "./Statistics";
import MemberInfoAndControl from "./MemberInfoAndControl";
import Tabs from "./Tabs";
import BuildHistory from "./BuildHistory";
import ProjectPanel from "./ProjectPanel";
import data from "../Mock/mockJenkinsResponse"

class MainScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: this.props.user,
        }
    }


    render() {
        return (
            <div className="limiter">
                <div className="container-main-screen100">
                    <div className="wrap-main-screen100">
                        <MemberInfoAndControl name={this.state.user.name} jobTitle={this.state.user.jobTitle}/>
                        <Tabs/>
                        <div className='main-panel-container'>
                            <BuildHistory buildHistoryList={data.builds}/>
                            <div className='project-panel-container'>
                                <ProjectPanel/>
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