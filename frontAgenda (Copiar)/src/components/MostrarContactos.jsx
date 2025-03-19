import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import AgendaDataService from "../services/agenda.service";
import TutorialService from "../services/tutorial.service"; // Nueva API para obtener tutoriales
import "./MostrarContactos.css";

const AgendaList = () => {
  const [contactos, setContactos] = useState([]); // Lista de clientes
  const [contactoSeleccionado, setContactoSeleccionado] = useState(null); // Cliente seleccionado
  const [tutoriales, setTutoriales] = useState([]); // Lista de tutoriales del contacto
  const [tutorialSeleccionado, setTutorialSeleccionado] = useState(null); // Tutorial seleccionado

  useEffect(() => {
    recibirContactos();
  }, []);

  const recibirContactos = async () => {
    try {
      const response = await AgendaDataService.getAll();
      setContactos(response.data);
    } catch (error) {
      console.error("❌ Error al obtener los contactos:", error);
    }
  };

  const borrarContacto = async (dni) => {
    try {
      await AgendaDataService.delete(dni);
      recibirContactos(); // Actualizar lista después de borrar
      setContactoSeleccionado(null);
      setTutoriales([]); // Limpiar tutoriales
      setTutorialSeleccionado(null);
    } catch (error) {
      console.error("❌ Error al eliminar contacto:", error);
    }
  };

  const seleccionarContacto = async (contacto) => {
    setContactoSeleccionado(contacto);
    setTutorialSeleccionado(null); // Resetear el tutorial seleccionado

    if (contacto.tutoriales && contacto.tutoriales.length > 0) {
      try {
        const response = await TutorialService.getByIds(contacto.tutoriales);
        setTutoriales(response.data);
      } catch (error) {
        console.error("❌ Error al obtener los tutoriales:", error);
      }
    } else {
      setTutoriales([]);
    }
  };

  return (
    <div className="container mt-4">
      <div className="row">
        {/* 📌 Sección Izquierda: Lista de Contactos */}
        <div className="col-md-6">
          <h4>📋 Contactos</h4>
          <table className="table table-hover table-bordered table-dark">
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
                    className={contacto === contactoSeleccionado ? "table-active" : ""}
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

        {/* 📌 Sección Derecha: Detalles del Contacto */}
        <div className="col-md-6">
          {contactoSeleccionado ? (
            <div className="card p-4 shadow">
              <h4>ℹ️ Detalles del Contacto</h4>
              <p><strong>Nombre:</strong> {contactoSeleccionado.nombre}</p>
              <p><strong>Apellido:</strong> {contactoSeleccionado.apellido}</p>
              <p><strong>DNI:</strong> {contactoSeleccionado.dni}</p>
              <p><strong>Dirección:</strong> {contactoSeleccionado.direccion}</p>
              <p><strong>E-Mail:</strong> {contactoSeleccionado.email}</p>
              <p><strong>Teléfono:</strong> {contactoSeleccionado.telefono}</p>


              <div className="d-flex gap-2">
                <Link to={`/editar/${contactoSeleccionado.dni}`} className="btn btn-primary">
                  ✏️ Editar
                </Link>
                <button className="btn btn-danger" onClick={() => borrarContacto(contactoSeleccionado.dni)}>
                  🗑️ Eliminar
                </button>
              </div>

              {/* 📌 Sección de Tutoriales */}
              <h5 className="mt-4">📚 Tutoriales de {contactoSeleccionado.nombre}</h5>
              {contactoSeleccionado.tutorialIds && contactoSeleccionado.tutorialIds.length > 0 ? (
                <ul>
                  {contactoSeleccionado.tutorialIds.map((id) => (
                    <li key={id}>Tutorial {id}</li> 
                  ))}
                </ul>
              ) : (
                <p>Este contacto no tiene tutoriales.</p>
              )}
            </div>
          ) : (
            <p className="text-muted">🔍 Haz clic en un cliente para ver los detalles...</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default AgendaList;
