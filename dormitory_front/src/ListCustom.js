import * as React from 'react';
import ListSubheader from '@mui/material/ListSubheader';
import List from '@mui/material/List';
import ResidentInfo from './ResidentInfo'
import Button from '@material-ui/core/Button';
import DeleteIcon from '@material-ui/icons/Delete';
import { makeStyles } from '@material-ui/core/styles';
import $api from "./http";

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


const DeleteResid=(id)=>{
  $api.delete(`residents/${id}`)
  window.location.reload();
}


  return (
    <List
      sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}
      component="nav"
      aria-labelledby="nested-list-subheader"
      subheader={
        <ListSubheader component="div" id="nested-list-subheader">
          Список проживающих студентов
        </ListSubheader>
      }
    >
      {props.items.map((item,key)=>{ 

          return (
            <div>
              <ResidentInfo id={item.id} name={item.first_name} surname={item.second_name}/>
                    <Button
                    onClick={ ()=>{DeleteResid(item.id)}}
              variant="contained"
              color="secondary"
              className={classes.button}
              startIcon={<DeleteIcon />}
            >
             Выселить
            </Button>
            </div>

            )
               })}
        
     
    </List>
  );
}

export default ListCustom;