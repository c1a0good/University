

import axios from 'axios';
import  ListCustom  from './ListCustom';
import Button from '@mui/material/Button'
import $api from "./http";
import React from "react";

import { Navigate } from 'react-router-dom';
import TextField from '@material-ui/core/TextField';


export default class PersonList extends React.Component {
  state = {
    persons: [],
    person_delete:[],
    redirect: false,
    value: 1
  }
  

  setRedirect = () => {
    this.setState({
      redirect: true
    })
  }


  renderRedirect = () => {
    if (this.state.redirect) {
      return <Navigate to='/login' />
    }
  }

  componentDidMount() {
    $api.get('residents/')
      .then(res => {
        const persons = res.data;
        console.log(persons)
        this.setState({ persons:persons });
        console.log(this.state.persons)
      })
  }

  UpdateResident(){
    $api.get('students/')
      .then(res => {
        const persons = res.data;
        console.log(persons)
      })
  }


  Addresident=()=>{
    $api.post('residents/',this.state.value)
    window.location.reload();
  }


  handleChange=(event)=>{
    this.setState({
      value: event.target.value,
    });
  }

  render() {
    return (
      <div>
        {this.renderRedirect()}
       <Button onClick={()=>{ localStorage.removeItem('token');   this.setRedirect()}} color="error">LogOut</Button>

       <div>
        <TextField
          id="outlined-number"
          label="id"
          type="number"
          InputLabelProps={{
            shrink: true,
          }}
          variant="outlined"
          value={this.state.value}
          onChange={this.handleChange}
        />
        
        <Button onClick={ this.Addresident }>
            Заселить учащегося
        </Button>
        </div>

        <ListCustom
        items={this.state.persons}/>
        <Button onClick={ this.UpdateResident }>
            Обновить список проживющих
        </Button>

      </div>
    )
  }
}