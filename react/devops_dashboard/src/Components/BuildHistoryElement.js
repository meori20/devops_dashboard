import React, { Component } from 'react';
import PropTypes from 'prop-types'
import '../css/BuildHistoryElement.css'

class BuildHistoryElement extends Component {
    constructor(props) {
        super(props);
        this.state = {
            buildNumber: this.props.buildNumber,
            buildNumberText: this.props.buildNumberText ? this.props.buildNumberText : 'Build: #',
            className: this.props.isSuccess ? 'build-number-success-container' : 'build-number-failed-container'
        }
    }

    render() {
        return (
            <div className={this.state.className}>
                <div className='build-number-text'>{this.state.buildNumberText}</div>
                <div className='build-number'>{this.state.buildNumber}</div>
            </div>
        );
    }

}

BuildHistoryElement.propTypes = {
    buildNumberText: PropTypes.string,
    buildNumber: PropTypes.number,
    isSuccess: PropTypes.bool
};



export default BuildHistoryElement;