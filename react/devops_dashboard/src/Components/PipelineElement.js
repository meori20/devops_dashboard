import React, { Component } from 'react';
import '../css/PipelineElement.css'

class PipelineElement extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: props.name,
            status: props.status,
            duration: props.duration
        }
    }
    componentWillReceiveProps(props){
        console.log('getting props' + JSON.stringify(props));
        this.setState({
            name: this.props.name,
            status: this.props.status,
            duration: this.props.duration
        })
    }

    componentDidMount(){
        console.log('component did mount with props: ' + this.props);
        this.setState({
            name: this.props.name,
            status: this.props.status,
            duration: this.props.duration
        })
    }

    render() {
        return (
            <div className='pipeline-element-container'>
                <div className='pipeline-element-header-container'>
                    <header className='pipeline-element-header'>{this.state.name}</header>
                </div>
                <div className='pipeline-element-time'>{this.state.duration}</div>
                <div className='pipeline-element-status-success-container'>
                    <div className='pipeline-element-status'>
                        {this.state.status}
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