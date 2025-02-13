import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import MostrarContactos from "./components/MostrarContactos";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

function App() {
  return (
    <Router>
      <div>
        {/* Barra de navegación */}
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to="/agenda" className="navbar-brand">
            Tutoriales
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to="/agenda" className="nav-link">
                Tutorials
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/add" className="nav-link">
                Add
              </Link>
            </li>
          </div>
        </nav>

        {/* Contenido de la aplicación */}
        <div className="container mt-3">
          <Routes>
            {/* Rutas para los componentes */}
            <Route path="/agenda" element={<MostrarContactos />} />
            <Route path="/" element={<MostrarContactos />} />
            {/* <Route path="/add" element={<AddTutorial />} /> */}
            {/* <Route path="/tutorials/:id" element={<Tutorial />} /> */}
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
