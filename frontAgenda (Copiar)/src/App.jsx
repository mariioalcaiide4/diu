import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { useAuthState } from "react-firebase-hooks/auth";
import { auth } from "./firebaseConfig";
import Navbar from './components/NavBar';
import Login from './components/Login';
import MostrarContactos from './components/MostrarContactos';
import AñadirContacto from './components/AñadirContacto';
import EditarContacto from './components/EditarContacto';


const PrivateRoute = ({ children }) => {
  const [user] = useAuthState(auth);
  return user ? children : <Navigate to="/login" />;
};

function App() {
  const [user] = useAuthState(auth);

  return (
    <Router>
      {user && <Navbar />} {/* La Navbar solo aparece si el usuario está autenticado */}
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<PrivateRoute><MostrarContactos /></PrivateRoute>} />
        <Route path="/Añadir" element={<PrivateRoute><AñadirContacto /></PrivateRoute>} />
        <Route path="/editar/:dni" element={<EditarContacto />} /> {/* Nueva ruta */}
      </Routes>
    </Router>
  );
}

export default App;

