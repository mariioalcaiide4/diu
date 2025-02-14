import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import AgendaList from "./components/MostrarContactos";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function App() {
  return (
    <div>
      <Router>
        <nav className="navbar">
          <Link to={"/agenda"} className="navbar-brand">
            Agenda
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/agenda"} className="nav-link">
                Agenda
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/add"} className="nav-link">
                Añadir
              </Link>
            </li>
          </div>
        </nav>
        <Routes>
          <Route path="/" element={<AgendaList />} />
          <Route path="/agenda" element={<AgendaList />} />
        </Routes>
      </Router>
    </div>
  );
}
  

export default App;

