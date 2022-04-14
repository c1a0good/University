import * as React from 'react';

import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Collapse from '@mui/material/Collapse';
import ExpandLess from '@mui/icons-material/ExpandLess';
import ExpandMore from '@mui/icons-material/ExpandMore';
import StudentsInfo from './StudentsInfo'


function ResidentInfo(props) {
  const [open, setOpen] = React.useState(false);

  const handleClick = (key) => {
    setOpen(!open)
  };

  return (
          <div>
          <ListItemButton onClick={handleClick}>
          <ListItemText primary={props.item.id+'. ' + props.item.firstName + ' '+ props.secondName}  />
          {open ? <ExpandLess /> : <ExpandMore />}
          </ListItemButton>
                <Collapse in={open} timeout="auto" unmountOnExit>
                <StudentsInfo id={props.id} name={props.name} surname={props.surname} />
              </Collapse>
              </div>
  );
}

export default ResidentInfo;