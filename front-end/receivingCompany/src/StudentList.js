


import  ListCustom  from './ListCustom';
import Button from '@mui/material/Button'
import $api from "./http";
import React from "react";
import TextField from '@material-ui/core/TextField';

export default class StatementList extends React.Component {
  state = {
    statements: [],
    value: 0
  }
  



  componentDidMount() {
    $api.get('statements/')
      .then(res => {
        const statements = res.data;
        this.setState({ statements:statements });
      })
  }


  AddStudent=()=>{
    $api.post('statements/',this.state.value)
    window.location.reload();
  }

  StartStatement=()=>{
    $api.post('statements/start')
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
            Добавить заявку
        </Button>
        <Button onClick={ this.StartStatement }>
            Receive Company
        </Button>
        </div>
      <div>
        <ListCustom
        items={this.state.statements}/>
      </div>
      </div>
    )
  }
}