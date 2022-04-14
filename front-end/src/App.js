
import './App.css';
import StudentList from './StudentList';

import { BrowserRouter as Router, Route,Routes ,Link } from "react-router-dom";
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/students"  element={<StudentList/>}/>
     </Routes>
     </Router>
  );
}

export default App;
