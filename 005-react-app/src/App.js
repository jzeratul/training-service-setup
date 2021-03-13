import logo from './logo.svg'
import axios from "axios"
import { useEffect, useState } from 'react'
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

import './App.css'
import {Button} from "react-bootstrap";



const xxx = [
  {
    name: 'Page A',
    uv: 4000,
    pv: 2400,
    amt: 2400,
  },
  {
    name: 'Page B',
    uv: 3000,
    pv: 1398,
    amt: 2210,
  },
  {
    name: 'Page C',
    uv: 2000,
    pv: 9800,
    amt: 2290,
  },
  {
    name: 'Page D',
    uv: 2780,
    pv: 3908,
    amt: 2000,
  },
  {
    name: 'Page E',
    uv: 1890,
    pv: 4800,
    amt: 2181,
  },
  {
    name: 'Page F',
    uv: 2390,
    pv: 3800,
    amt: 2500,
  },
  {
    name: 'Page G',
    uv: 3490,
    pv: 4300,
    amt: 2100,
  },
];



export const App = () => {

  const [data, setData] = useState([]);

  const loadData = () => {
    axios.get("http://localhost:9600/training-app/api/v1/data").then(

      (response) => {


        console.log(response.data)

        setData((curentData) => [...curentData, response.data]);
      },
      (error) => {

        console.log(error);
      }
    )
  }

  useEffect(() => {
    loadData();
  }, [])

  const onclick = () => {
    loadData();
  }

  return (

    <main>
      <img src={logo} className="App-logo" alt="logo" width={60} height={60}/>
      <section className="content mt-5">
        <div className="container-fluid">
          <div className="row">
            <ResponsiveContainer width="100%" height="100%">
              <LineChart
                width={500}
                height={300}
                data={data}
                margin={{
                  top: 5,
                  right: 30,
                  left: 20,
                  bottom: 5,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="pv" stroke="#8884d8" activeDot={{ r: 8 }} />
                <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
              </LineChart>
            </ResponsiveContainer>

            <Button variant={"info"} onClick={onclick} > Reload</Button>
          </div>
        </div>
      </section>
    </main>
  );
}

export default App
