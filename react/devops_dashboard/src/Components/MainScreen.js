import React, { Component } from 'react';
import "../css/MainSecreen.css";

class MainScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'Mai Zuli',
            jobTitle: 'Developer'
        }
    }

    render() {
        return (
            <div className="limiter">
                <div className="container-main-screen100">
                    <div className="wrap-main-screen100">
                        <div className='member-and-logout'>
                            <div className='member-container'>
                                <div className='member-table'>
                                    <div>
                                        <h3 className='member-name'>{this.state.name}</h3>
                                    </div>
                                    <div>
                                        <h3 className='member-separator'>{' | '}</h3>
                                    </div>
                                    <div>
                                        <h3 className='member-job-title'>{this.state.jobTitle}</h3>

                                    </div>
                                </div>
                            </div>
                            <div className='logout-container'>
                                <button className='logout-btn'>logout</button>
                            </div>

                        </div>
                        <div className='tabs-container'>
                            <div className='microservice-container'>
                                <header className='microservice-header'>Microservice</header>
                            </div>
                            <div className='project-domain-container'>
                                <header className='microservice-header'>Project Domain</header>
                            </div>
                        </div>
                        <div className='main-panel-container'>
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
                            <div
                                className='project-panel-container'>
                                <div className='project-tools-container'>
                                    <div className='project-list-container'>
                                        <select>
                                            <option>225</option>
                                            <option>224</option>
                                            <option>223</option>
                                        </select>
                                    </div>
                                    <div className='project-searchBar-container'>
                                        <div className={'project-searchBar'}>
                                            <input className='project-searchBar-input' type="search" id="site-search" name="q"
                                                   placeholder="Search the site..."
                                                   aria-label="Search through site content"/>
                                            <button className='project-searchBar-btn'>Search</button>
                                        </div>
                                    </div>
                                </div>
                                <div className='all-statistic-container'>
                                    <div className='pipeline-container'>
                                        <div className='pipeline-list'>
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
                                            <div className='pipeline-element-container'>
                                                <div className='pipeline-element-header-container'>
                                                    <header className='pipeline-element-header'>header</header>
                                                </div>
                                                <div className='pipeline-element-time'>5 min</div>
                                                <div className='pipeline-element-status-failed-container'>
                                                    <div className='pipeline-element-status'>
                                                        Failed
                                                    </div>
                                                    <div className='pipeline-element-avg-time'>
                                                        2s
                                                    </div>
                                                    <div className='pipeline-element-logs-ref'>
                                                        click for logs
                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>

                                    <div className='statistics-container'>

                                        <div className={'statistics-element-container'}>
                                            <div className='statistics-element'>
                                                <div className='statistics-element-header-container'>
                                                    <header className='statistics-element-header'>header</header>
                                                </div>
                                                <div className='statistics-element-body-container'>

                                                </div>
                                            </div>
                                        </div>

                                        <div className={'statistics-element-container'}>
                                            <div className='statistics-element'>
                                                <div className='statistics-element-header-container'>
                                                    <header className='statistics-element-header'>header</header>
                                                </div>
                                                <div className='statistics-element-body-container'>

                                                </div>
                                            </div>
                                        </div>

                                        <div className={'statistics-element-container'}>
                                            <div className='statistics-element'>
                                                <div className='statistics-element-header-container'>
                                                    <header className='statistics-element-header'>header</header>
                                                </div>
                                                <div className='statistics-element-body-container'>

                                                </div>
                                            </div>
                                        </div>

                                        <div className={'statistics-element-container'}>
                                            <div className='statistics-element'>
                                                <div className='statistics-element-header-container'>
                                                    <header className='statistics-element-header'>header</header>
                                                </div>
                                                <div className='statistics-element-body-container'>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        </div>
                    </div>
            </div>
        );
    }
}

export default MainScreen;