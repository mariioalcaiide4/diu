import 'bootstrap/dist/css/bootstrap.min.css'; // Importa Bootstrap
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AñadirContacto from './components/AñadirContacto';
import Navbar from './components/NavBar';
import MostrarContactos from './components/MostrarContactos';

function App() {
  return (
    <Router>
      <div className="app-container">
        <Navbar />
        <Routes>
          <Route path="/" element={<MostrarContactos />} />
          <Route path="/Añadir" element={<AñadirContacto />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
