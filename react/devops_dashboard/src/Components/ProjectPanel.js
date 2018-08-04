import React, { Component } from 'react';
import '../css/ProjectPanel.css'

class ProjectPanel extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
                <div className='project-panel-container'>
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
                </div>
        );
    }
}

export default ProjectPanel;