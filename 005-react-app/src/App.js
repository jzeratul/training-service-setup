import logo from './logo.svg'
import axios from "axios"
import { useEffect, useState } from 'react'
import { Col, Container, Row } from "react-bootstrap";

import './App.css'
import {Button} from "react-bootstrap";
import React from "react";
import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend
} from "recharts";


const API_URL = 'http://localhost:9600/training-app/api/v1/data';

export default function App() {

  const [data1, setData] = useState([])

  const loadData = () => {
    axios.get(`${API_URL}`, ).then(
      (response) => {
        setData(response.data)
      },
      (error) => {
        console.log(">>>>>>" + error)
      }
    )
  }

  useEffect(() => {
    loadData();
  }, [])


  const onReloadClick = () => {
    loadData();
  }


  return (
    <main>

      <Container>
        <img src={logo} className="App-logo" alt="logo" width={60} height={60}/>
      </Container>

      <Container>
        <Button variant={"info"} onClick={onReloadClick} > Reload</Button>
      </Container>


      <Container>
        <LineChart
          width={1500}
          height={800}
          data={data1}
          margin={{
            top: 5,
            right: 30,
            left: 0,
            bottom: 5
          }}
        >
          <XAxis dataKey="x" />
          <YAxis />
          <Legend />
          <Line
            type="monotone"
            dataKey="value"
            stroke="#8884d8"
          />
        </LineChart>
      </Container>

    </main>
  );
}

