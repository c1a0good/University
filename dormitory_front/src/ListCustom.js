import * as React from 'react';
import ListSubheader from '@mui/material/ListSubheader';
import List from '@mui/material/List';
import ResidentInfo from './ResidentInfo'


function ListCustom(props) {
  const [open, setOpen] = React.useState(true);

  const handleClick = (key) => {
    setOpen(!open)
  };

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
            <ResidentInfo id={item.id} name={item.first_name} surname={item.second_name}/>
            )
               })}
        
     
    </List>
  );
}

export default ListCustom;