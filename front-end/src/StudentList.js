


import  ListCustom  from './ListCustom';
import Button from '@mui/material/Button'
import $api from "./http";
import React from "react";
import TextField from '@material-ui/core/TextField';

export default class PersonList extends React.Component {
  state = {
    persons: [],

  }
  



  componentDidMount() {
    $api.get('students/')
      .then(res => {
        const persons = res.data;
        this.setState({ persons:persons });
      })
  }


  AddStudent=()=>{
    $api.post('students/',this.state.value)
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
        
        <Button onClick={ this.AddStudent }>
            Добавить студента
        </Button>
        </div>
      <div>
        <ListCustom
        items={this.state.persons}/>
      </div>
      </div>
    )
  }
}