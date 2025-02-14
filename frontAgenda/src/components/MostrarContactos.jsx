import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import AgendaDataService from "../services/agenda.service";

const AgendaList = () => {
  const [contactos, setContactos] = useState([]);  // Lista de clientes
  const [contactoSeleccionado, setContactoSeleccionado] = useState(null); // Cliente seleccionado

  // Obtener datos de la API
  useEffect(() => {
    recibirContactos();
  }, []);

  const recibirContactos = () => {
    AgendaDataService.getAll()
      .then(response => {
        setContactos(response.data);
      })
      .catch(error => {
        console.error("Error al obtener los contactos:", error);
      });
  };

  const borrarContacto = (dni) => {
    AgendaDataService.delete(dni)
      .then(() => {
        recibirContactos(); // Actualizar lista después de borrar
        setContactoSeleccionado(null);
      })
      .catch(error => {
        console.error("Error al eliminar contacto:", error);
      });
  };

  return (
    <div className="list">
      {/* 📌 Sección izquierda: Lista de clientes */}
      <div className="col-md-4">
        <h4>Lista de Clientes</h4>
        <table className="table">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Apellidos</th>
            </tr>
          </thead>
          <tbody>
            {contactos.length > 0 ? (
              contactos.map((contacto, index) => (
                <tr
                  key={index}
                  className={contacto === contactoSeleccionado ? "active" : ""}
                  onClick={() => setContactoSeleccionado(contacto)}
                  style={{ cursor: "pointer" }}
                >
                  <td>{contacto.nombre}</td>
                  <td>{contacto.apellido}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="2">No hay clientes...</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>

      {/* 📌 Sección derecha: Detalles del cliente seleccionado */}
      <div className="col-md-8">
        {contactoSeleccionado ? (
          <div>
            <h4>Detalles del Cliente</h4>
            <p><strong>Nombre:</strong> {contactoSeleccionado.nombre}</p>
            <p><strong>Apellido:</strong> {contactoSeleccionado.apellido}</p>
            <p><strong>DNI:</strong> {contactoSeleccionado.dni}</p>

            <button>
              <Link to={`/agenda/${contactoSeleccionado.dni}`} style={{ color: "white", textDecoration: "none" }}>
                Editar
              </Link>
            </button>
            <button onClick={() => borrarContacto(contactoSeleccionado.dni)} style={{ backgroundColor: "red" }}>
              Eliminar
            </button>
          </div>
        ) : (
          <p>Haz clic en un cliente para ver los detalles...</p>
        )}
      </div>
    </div>
  );
};

export default AgendaList;
