import logo from './logo.svg';
import './App.css';
import FacultyList from "./Faculty";
import SpecialtyList from "./Specialty";
import DisciplineList from "./Discipline";
import { BrowserRouter as Router, Route,Routes ,Link } from "react-router-dom";
function App() {
  return (
    <div className="App">
        <Router>
            <Routes>
                <Route path="/faculties" element={<FacultyList/>} />
                <Route path="/specialties" element={<SpecialtyList/>} />
                <Route path="/disciplines" element={<DisciplineList/>} />
            </Routes>
        </Router>
    </div>
  );
}

export default App;
