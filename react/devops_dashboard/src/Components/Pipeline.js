import React, { Component } from 'react';

import PipelineElement from "./PipelineElement";
import '../css/Pipeline.css'

class Pipeline extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='pipeline-container'>
                <div className='pipeline-list'>
                    <PipelineElement/>
                    <PipelineElement/>
                    <PipelineElement/>
                    <PipelineElement/>
                    <PipelineElement/>
                </div>
            </div>
        );
    }
}

export default Pipeline;