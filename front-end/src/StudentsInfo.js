import React from 'react';
import List from '@mui/material/List';
import ListItemText from '@mui/material/ListItemText';
import axios from 'axios';
import $api from "./http";


export default class StudentsInfo extends React.Component {
  state = {
    student: {}
  }

  componentDidMount() {
  $api.get(`students/${this.props.id}`)
      .then(res => {
        const student = res.data;
        console.log(student)
        this.setState({ student });
        console.log(this.state.student)
      })
  }

  render() {
    return (
     <List>
            <ListItemText primary={this.state.student} />
    </List>
    )
  }
}