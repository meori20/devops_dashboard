import React, { Component } from 'react';
import PropTypes from 'prop-types';
import '../css/BuildHistory.css'
import BuildHistoryElement from "./BuildHistoryElement";

class BuildHistory extends Component {
    constructor(props) {
        super(props);
        this.state = {
            buildHistoryList: this.props.buildHistoryList
        }
    }

    renderBuildHistoryList(buildHistoryElement){
        return <BuildHistoryElement isSuccess={buildHistoryElement.bool} buildNumberText={buildHistoryElement.numberText} buildNumber={buildHistoryElement.number}/>
    }

    render() {
        return (
            <div className='build-history-container'>
                <header className='build-history-header'>Build History</header>
                <div className='build-number-list'>
                    {this.state.buildHistoryList.map((buildElement, index) => {
                        this.renderBuildHistoryList(buildElement);
                    })}
                </div>
            </div>

        );
    }
}

BuildHistory.propTypes = {
    buildHistoryList: PropTypes.array
};

export default BuildHistory;