import logo from './logo.svg';
import './App.css';
import PersonList from './PersonList';
import  LoginPage  from './LoginPage';
import RequireAuth from './RequireAuth'
import { BrowserRouter as Router, Route,Routes ,Link } from "react-router-dom";
function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/login" element={<LoginPage/>}/>
        <Route path="/resident_list"  element={<RequireAuth><PersonList/></RequireAuth>}/>
     </Routes>
     </Router>
  //  <PersonList/>
  );
}

export default App;
