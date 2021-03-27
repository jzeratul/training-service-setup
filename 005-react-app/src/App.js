import logo from './logo.svg'
import axios from "axios"
import React, { useState, useEffect } from 'react';
import { Container, Card } from "react-bootstrap";

import './App.css'
import { Button } from "react-bootstrap";

import { LineChart, Line, XAxis, YAxis, Legend, Label } from "recharts";


const API_URL = '/training-app/api/v1/data';

export default function App() {

  const [data1, setData] = useState([])
  const [datasize, setDataSize] = useState(0)


  const loadData = () => {
    axios.get(`${API_URL}`,).then(
      (response) => {
        setData(response.data)
        console.log(response.data.length)
        setDataSize(response.data.length)
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
        <img src={logo} className="App-logo" alt="logo" width={60} height={60} />
      </Container>


      <Card>
        <Card.Body>

          <Container>

            <Button variant={"info"} onClick={onReloadClick} > Reload</Button>

            <p>
              Data size loaded: {datasize}
            </p>

          </Container>

          <Container>
            <LineChart width={500} height={300} data={data1} margin={{ top: 5, right: 30, left: 0, bottom: 5 }} >
              <XAxis dataKey="x" />
              <YAxis />
              <Legend />
              <Line type="monotone" dataKey="value" stroke="#8884d8" />
            </LineChart>
          </Container>
        </Card.Body>
      </Card>
    </main>
  );
}

