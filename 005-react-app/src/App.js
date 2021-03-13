import logo from './logo.svg';
import axios from "axios";
import { useEffect, useState } from 'react';
import {
  BarChart,
  Bar,
  Line,
  LineChart,
  XAxis,
  YAxis,
  Tooltip
} from 'recharts';import './App.css';
import io from 'socket.io-client';

// const API_URL = 'http://localhost:9600/training-app/api/v1/data';
const API_URL = 'http://localhost:9604/v1/data';

// const getMessage = () => {
//   return axios.get(`${API_URL}`);
// }

const socket = io('http://localhost:9604/v1/data', {
  transports: ['websocket', 'polling']
});

function App() {

  const [data, setData] = useState([]);

  useEffect(() => {

    socket.on('cpu', newData => {
      setData(currentData => [...currentData, newData]);
    });

  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <LineChart width={500} height={300} data={data}>
          <XAxis dataKey="contents" />
          <YAxis />
          <Line dataKey="value" />
        </LineChart>
      </header>
    </div>
  );
}

export default App;
