import React, { Component } from 'react';
import '../css/BuildHistory.css'

class BuildHistory extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='build-history-container'>
                <header className='build-history-header'>Build History</header>
                <div className='build-number-list'>
                    <div className='build-number-container'>
                        <div className='build-number-text'>Build:</div>
                        <div className='build-number'>#1234</div>
                    </div>
                    <div className='build-number-container'>
                        <div className='build-number-text'>Build:</div>
                        <div className='build-number'>#1234</div>
                    </div>
                </div>
            </div>

        );
    }
}

export default BuildHistory;