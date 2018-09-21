import React, { Component } from 'react';

import PipelineElement from "./PipelineElement";
import '../css/Pipeline.css'
import {BuildStatus} from "../Utils/AppEnums";

class Pipeline extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stages: props.stages,
            ableToLoadPipeLine: props.ableToLoadPipeLine
        }
    }

    renderPipelineElement(element, index){
        return <PipelineElement name={element.name} status={element.status} duration={element.durationMillis} key={`${element.name}.${element.id}`}/>;
    }

    componentWillReceiveProps(props){
        this.setState({
            stages: props.stages,
            ableToLoadPipeLine: props.ableToLoadPipeLine
        })
    }

    componentDidMount(){
        console.log('component did mount with props: ' + this.props);

    }


    getPipelineElements(){
        if(this.state.stages){
            return this.state.stages.map((element, index) => {
                return this.renderPipelineElement(element, index);
            })
        }
    }

    render() {
        return (
            <div className='pipeline-container'>
                <div className='pipeline-list'>
                    {this.state.ableToLoadPipeLine ? this.getPipelineElements() : <div className='pipeline-unable-to-load'>unable to load Pipline</div>}
                </div>
            </div>
        );
    }
}

export default Pipeline;