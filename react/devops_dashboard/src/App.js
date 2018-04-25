import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to Devops Dashboard Demo</h1>
        </header>
        <p className="App-intro">
          in this demo we will show how our backend handles with jenkins and updates the information to react app
        </p>
      </div>
    );
  }
}

export default App;
