import React, { Component } from 'react';
import '../css/Statistics.css'
import StatisticsElement from "./StatisticsElement";

class Statistics extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sonarQube: props.sonarQube,
        }
    }

    componentWillReceiveProps(props){
        this.setState({
            sonarQube: props.sonarQube,
        })
    }

    getSonarText(){
        if(this.state.sonarQube){
            return (
                <div>
                    <div className='statistics-element-body-text'>
                        {`Code Coverage: ${this.state.sonarQube.m_CodeCoverage}`}
                    </div>
                    <div className='statistics-element-body-text'>
                        {`Code Smells: ${this.state.sonarQube.m_CodeSmells}`}
                    </div>
                    <div className='statistics-element-body-text'>
                        {`For More Details:`}
                        <div style={{cursor: 'pointer'}}>{this.state.sonarQube.m_SonarRefURL}</div>
                    </div>
                </div>
            )

        }

    }

    render() {
        return (
            <div className='statistics-container'>
                {this.state.sonarQube && <StatisticsElement header={'Sonar'} body={this.getSonarText()}/>}
            </div>
        );
    }
}

export default Statistics;