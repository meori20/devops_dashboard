import React, { Component } from 'react';
import "../css/MainSecreen.css";
import Pipeline from "./Pipeline";
import StatisticsElement from "./StatisticsElement";
import Statistics from "./Statistics";
import MemberInfoAndControl from "./MemberInfoAndControl";
import Tabs from "./Tabs";
import BuildHistory from "./BuildHistory";
import ProjectPanel from "./ProjectPanel";

class MainScreen extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="limiter">
                <div className="container-main-screen100">
                    <div className="wrap-main-screen100">
                        <MemberInfoAndControl/>
                        <Tabs/>
                        <div className='main-panel-container'>
                            <BuildHistory/>
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

export default MainScreen;