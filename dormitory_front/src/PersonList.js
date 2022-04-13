

import axios from 'axios';
import  ListCustom  from './ListCustom';
import Button from '@mui/material/Button'
import $api from "./http";
import React, { useState,FC,useContext } from "react";
import {observer} from "mobx-react-lite";
import {Context} from './index'
import { Navigate } from 'react-router-dom';

export default class PersonList extends React.Component {
  state = {
    persons: [],
    person_delete:[],
    redirect: false
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

  render() {
    return (
      <div>
        {this.renderRedirect()}
       <Button onClick={()=>{ localStorage.removeItem('token');   this.setRedirect()}} color="error">LogOut</Button>
        <ListCustom
        items={this.state.persons}/>
        <Button onClick={ this.UpdateResident }>
            Обновить список проживющих
        </Button>
      </div>
    )
  }
}