import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import AgendaDataService from "../services/agenda.service";
 // Asegúrate de importar el servicio de datos

const AgendaList = () => {
  const [contactos, setContactos] = useState([]);
  const [contactoSeleccionado, setContactoSeleccionado] = useState(null);
  const [currentIndex, setCurrentIndex] = useState(-1);
  const [busquedaNombre, setBusquedaNombre] = useState("");

  useEffect(() => {
    recibirContactos();
  }, []);

  const recibirContactos = () => {
    AgendaDataService.getAll()
      .then(response => {
        setContactos(response.data);
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  };

  const onChangeBusqueda = (e) => {
    setBusquedaNombre(e.target.value);
  };

  const buscarNombre = () => {
    AgendaDataService.findByNombre(busquedaNombre)
      .then(response => {
        setContactos(response.data);
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  };

  const removeAllContactos = () => {
    AgendaDataService.deleteAll()
      .then(response => {
        console.log(response.data);
        refrescarLista();
      })
      .catch(e => {
        console.log(e);
      });
  };

  const refrescarLista = () => {
    recibirContactos();
    setContactoSeleccionado(null);
    setCurrentIndex(-1);
  };

  const setActiveContacto = (contacto, index) => {
    setContactoSeleccionado(contacto);
    setCurrentIndex(index);
  };

  return (
    <div className="list row">
      <div className="col-md-8">
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Search by title"
            value={busquedaNombre}
            onChange={onChangeBusqueda}
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              type="button"
              onClick={buscarNombre}
            >
              Search
            </button>
          </div>
        </div>
      </div>
      <div className="col-md-6">
        <h4>Lista de Contactos</h4>

        <ul className="list-group">
          {contactos &&
            contactos.map((contacto, index) => (
              <li
                className={
                  "list-group-item " + (index === currentIndex ? "active" : "")
                }
                onClick={() => setActiveContacto(contacto, index)}
                key={index}
              >
                {contacto.nombre}
              </li>
            ))}
        </ul>

        <button
          className="m-3 btn btn-sm btn-danger"
          onClick={removeAllContactos}
        >
          Remove All
        </button>
      </div>
      <div className="col-md-6">
        {contactoSeleccionado ? (
          <div>
            <h4>Contacto</h4>
            <div>
              <label>
                <strong>Nombre Completo:</strong>
              </label>{" "}
              {contactoSeleccionado.nombre + " " + contactoSeleccionado.apellido}
            </div>
            <div>
              <label>
                <strong>Email:</strong>
              </label>{" "}
              {contactoSeleccionado.email}
            </div>
            <div>
              <label>
                <strong>Teléfono:</strong>
              </label>{" "}
              {contactoSeleccionado.telefono}
            </div>
            <div>
              <label>
                <strong>Edad:</strong>
              </label>{" "}
              {contactoSeleccionado.edad}
            </div>
            <div>
              <label>
                <strong>Dirección:</strong>
              </label>{" "}
              {contactoSeleccionado.direccion}
            </div>

            <Link
              to={"/agenda/" + contactoSeleccionado.dni}
              className="badge badge-warning"
            >
              Edit
            </Link>
          </div>
        ) : (
          <div>
            <br />
            <p>Por favor selecciona un contacto...</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default AgendaList;

















































// Configura el modal
/*Modal.setAppElement("#root");

function MostrarContactos() {
    const [contactos, setContactos] = useState([]); // Estado inicial vacío
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [contactoSeleccionado, setContactoSeleccionado] = useState(null);

    useEffect(() => {
        axios
            .get("http://localhost:8090/api/v1/agenda")
            .then((response) => {
                setContactos(response.data);
            })
            .catch((error) => {
                console.error("Error al obtener los contactos", error);
            });
    }, []);

    // Función para abrir el modal
    const openModal = (contacto) => {
        setContactoSeleccionado(contacto);
        setIsModalOpen(true);
    };

    // Función para cerrar el modal
    const closeModal = () => {
        setIsModalOpen(false);
        setContactoSeleccionado(null);
    };

    return (
        <div>
            <h1>Agenda de Contactos</h1>

            <div className="contact-list">
                {contactos.map((contacto) => (
                    <div key={contacto.dni} className="contact-card">
                        <h3>{contacto.nombre} {contacto.apellido}</h3>
                        <button onClick={() => openModal(contacto)}>Ver detalles</button>
                    </div>
                ))}
            </div>

            {contactoSeleccionado && (
                <Modal isOpen={isModalOpen} onRequestClose={closeModal} contentLabel="Contacto Detalles">
                    <h2>Detalles de {contactoSeleccionado.nombre} {contactoSeleccionado.apellido}</h2>
                    <p><strong>DNI:</strong> {contactoSeleccionado.dni}</p>
                    <p><strong>Edad:</strong> {contactoSeleccionado.edad}</p>
                    <p><strong>Teléfono:</strong> {contactoSeleccionado.telefono}</p>
                    <button onClick={closeModal}>Cerrar</button>
                </Modal>
            )}
        </div>
    );
}

export default MostrarContactos;
*/

