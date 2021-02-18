import logo from './logo.svg';
import axios from "axios";
import React, { useState, useEffect } from "react";
import './App.css';

const API_URL = 'http://localhost/training-service/api/v1/data';

const getMessage = () => {
  return axios.get(`${API_URL}/message`);
}

function App() {

  const [message, setMessage] = useState(null);

  useEffect(() => {

    getMessage().then(
      (response) => {
        setMessage(response.data);
      },
      (error) => {
        setMessage(error.response.data)
      }
    )
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <span>{message}</span>
      </header>
    </div>
  );
}

export default App;
