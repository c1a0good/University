import * as React from 'react';
import ListSubheader from '@mui/material/ListSubheader';
import List from '@mui/material/List';
import ResidentInfo from './ResidentInfo'
import $api from './http/index'
import Button from '@material-ui/core/Button';
import DeleteIcon from '@material-ui/icons/Delete';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
  button: {
    margin: theme.spacing(1),
  },
}));


function ListCustom(props) {
  const [open, setOpen] = React.useState(true);
  const classes = useStyles();

  const handleClick = (key) => {
    setOpen(!open)
  };


  const DeleteStud=(id)=>{
    $api.delete(`students/${id}`)
    window.location.reload();
  }

  return (
    <List
      sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}
      component="nav"
      aria-labelledby="nested-list-subheader"
      subheader={
        <ListSubheader component="div" id="nested-list-subheader">
          Список  студентов
        </ListSubheader>
      }
    >
      {props.items.map((item,key)=>{ 

          return (
            <div>
              <ResidentInfo id={item.id} name={item.firstName} surname={item.secondName}/>
                    <Button
                    onClick={ ()=>{DeleteStud(item.id)}}
              variant="contained"
              color="secondary"
              className={classes.button}
              startIcon={<DeleteIcon />}
            >
             Удалить студента
            </Button>
            </div>

            )
               })}
        
     
    </List>
  );
}

export default ListCustom;