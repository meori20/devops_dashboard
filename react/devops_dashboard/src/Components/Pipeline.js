import React, { Component } from 'react';

import PipelineElement from "./PipelineElement";
import '../css/Pipeline.css'
import {BuildStatus} from "../Utils/AppEnums";

class Pipeline extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stages: props.stages,
            ableToLoadPipeline: props.ableToLoadPipeline
        }
    }

    renderPipelineElement(element, index){
        return <PipelineElement name={element.name} status={element.status} duration={element.durationMillis} key={`${element.name}.${element.id}`}/>;
    }

    componentWillReceiveProps(props){
        // console.log('getting props' + JSON.stringify(props));
        this.setState({
            stages: props.stages,
            ableToLoadPipeline: props.ableToLoadPipeline
        })
    }

    componentDidMount(){
        console.log('component did mount with props: ' + this.props);

    }


    getPipelineElements(){
        if(this.state.ableToLoadPipeline){
            return this.state.stages.map((element, index) => {
                return this.renderPipelineElement(element, index);
            })
        }else{
            return <div/>
        }
    }

    render() {
        return (
            <div className='pipeline-container'>
                <div className={this.state.ableToLoadPipeline ? 'pipeline-list' : 'pipeline-list-unavailable'}>
                    {this.state.ableToLoadPipeline ? this.getPipelineElements() : <div className='pipeline-unable-to-load'>unable to load Pipline</div>}
                </div>
            </div>
        );
    }
}

export default Pipeline;