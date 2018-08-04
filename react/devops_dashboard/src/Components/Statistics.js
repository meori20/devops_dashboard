import React, { Component } from 'react';
import '../css/Statistics.css'
import StatisticsElement from "./StatisticsElement";

class Statistics extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className='statistics-container'>
                <StatisticsElement/>
                <StatisticsElement/>
            </div>
        );
    }
}

export default Statistics;