import React, { Component } from 'react';
import '../css/PipelineElement.css'

class PipelineElement extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='pipeline-element-container'>
                <div className='pipeline-element-header-container'>
                    <header className='pipeline-element-header'>header</header>
                </div>
                <div className='pipeline-element-time'>5 min</div>
                <div className='pipeline-element-status-success-container'>
                    <div className='pipeline-element-status'>
                        Success
                    </div>
                    <div className='pipeline-element-avg-time'>
                        2s
                    </div>
                    <div className='pipeline-element-logs-ref'>
                        click for logs
                    </div>
                </div>

            </div>
        );
    }
}

export default PipelineElement;