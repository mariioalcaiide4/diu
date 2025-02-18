import 'bootstrap/dist/css/bootstrap.min.css'; // Importa el CSS de Bootstrap
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link, Navigate } from 'react-router-dom';
import AñadirContacto from './components/AñadirContacto';
import Navbar from './components/NavBar';
import MostrarContactos from './components/MostrarContactos';

function App() {

  return (
    <Router>
      <Navbar />
      <div style={{ padding: "20px" }}>
        <Routes>
          <Route path="/" element={<MostrarContactos />} />
          <Route path="/add" element={<AñadirContacto />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
  
  
  