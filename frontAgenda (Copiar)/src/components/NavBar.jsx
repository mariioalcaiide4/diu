import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import { FaUserCircle } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import { signOut } from "firebase/auth";
import { auth } from "../firebaseConfig";
import { useAuthState } from "react-firebase-hooks/auth";

const Navbar = () => {
  const [user] = useAuthState(auth);

  return (
    <nav className="navbar navbar-expand-lg color1 text-white">
      <div className="container-fluid">
        {/* Botón de hamburguesa */}
        <button
          className="navbar-toggler d-lg-none"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        {/* Enlaces de la barra de navegación */}
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link to="/Añadir" className="nav-link text-white">Añadir Contacto</Link>
            </li>
            <li className="nav-item">
              <Link to="/Tutoriales" className="nav-link text-white">Ver Tutoriales</Link>
            </li>
          </ul>
        </div>

        {/* Título centrado */}
        <Link to="/" className="text-white navbar-brand position-absolute start-50 translate-middle-x">
          Agenda
        </Link>

        {/* Usuario autenticado */}
        {user && (
          <div className="d-flex align-items-center ms-auto">
            {/* Avatar y nombre */}
            <div className="dropdown">
              <FaUserCircle className="fs-3" />
              <span>{user.displayName || user.email}</span>
              <button className="btn btn-danger ms-2" onClick={() => signOut(auth)}>
                Cerrar sesión
              </button>
            </div>
          </div>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
