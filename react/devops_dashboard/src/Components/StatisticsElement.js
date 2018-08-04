import React, { Component } from 'react';
import '../css/StatisticsElement.css'

class StatisticsElement extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={'statistics-element-container'}>
                <div className='statistics-element'>
                    <div className='statistics-element-header-container'>
                        <header className='statistics-element-header'>header</header>
                    </div>
                    <div className='statistics-element-body-container'>

                    </div>
                </div>
            </div>
        );
    }
}

export default StatisticsElement;