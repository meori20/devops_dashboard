import React, { Component } from 'react';

import './App.css';
import Login from "./Components/Login";
import MainScreen from "./Components/MainScreen";

class App extends Component {
  render() {
    return (
      <div style={styles.app} className="App">
          <MainScreen user={{name:'Man Makoner', jobTitle: 'Developer'}}/>
      </div>
    );
  }
}

let styles = {
  app: {
      alignItems: 'center',
      justifyContent: 'center',
      flex: 1,
      height: 600

  }
};

export default App;
