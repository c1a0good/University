
import './App.css';
import StatementList from './StudentList';

import { BrowserRouter as Router, Route,Routes ,Link } from "react-router-dom";
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/statements"  element={<StatementList/>}/>
     </Routes>
     </Router>
  );
}

export default App;
