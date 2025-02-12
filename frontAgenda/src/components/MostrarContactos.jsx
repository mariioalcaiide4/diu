import React, { useState, useEffect } from "react";
import axios from "axios";
import Modal from "react-modal";

// Configura el modal
Modal.setAppElement("#root");

function MostrarContactos() {
    const [contactos, setContactos] = useState([]); // Estado inicial vacío
    const [isModalOpen, setIsModalOpen] = useState(false);
    const {contactoSeleccionado, setContactoSeleccionado} = useState(null);

    useEffect(() => {
        axios
            .get("http://localhost:8090/api/v1/agenda")        .
            then((response) => {
                setContactos(response.data);
            })
            .catch((error) => {
                console.error("Error al obtener los contactos", error);
            });
    }, []);

    // Función para abrir el modal
  const openModal = (contacto) => {
    setSelectedContact(contacto);
    setIsModalOpen(true);
  };

  // Función para cerrar el modal
  const closeModal = () => {
    setIsModalOpen(false);
    setSelectedContact(null);
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

      {selectedContact && (
        <Modal isOpen={isModalOpen} onRequestClose={closeModal} contentLabel="Contacto Detalles">
          <h2>Detalles de {selectedContact.nombre} {selectedContact.apellido}</h2>
          <p><strong>DNI:</strong> {selectedContact.dni}</p>
          <p><strong>Edad:</strong> {selectedContact.edad}</p>
          <p><strong>Teléfono:</strong> {selectedContact.telefono}</p>
          <button onClick={closeModal}>Cerrar</button>
        </Modal>
      )}
    </div>
  );
}

export default App;








