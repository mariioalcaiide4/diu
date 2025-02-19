import React, { useState } from "react";
import AgendaDataService from "../services/agenda.service";
import Navbar from "./NavBar"; 
import "./AñadirContacto.css";

const AñadirContacto = () => {
  const [contacto, setContacto] = useState({
    Dni: "",
    Nombre: "",
    Apellido: "",
    edad: "",
    Telefono: "",
    Email: "",
    Direccion: ""
  });

  // Manejar cambios en los inputs
  const handleChange = (event) => {
    const { name, value } = event.target;
    setContacto((prevContacto) => ({
      ...prevContacto,
      [name]: value
    }));
  };

  // Guardar contacto en la base de datos
  const saveContacto = () => {
    AgendaDataService.create(contacto)
      .then((response) => {
        console.log("Contacto creado:", response.data);
        setContacto({ Dni: "", Nombre: "", Apellido: "", edad: "", Telefono: "", Email: "", Direccion: "" });
        alert("Contacto guardado exitosamente!");
      })
      .catch((error) => {
        console.error("Error al guardar el contacto:", error);
      });
  };

  return (
    <div className="container">
      <Navbar />
      <div className="form-container">
        <h2 className="text-center mb-4">Añadir Contacto</h2>
        <form>
          {[
            { label: "DNI", name: "Dni", type: "text" },
            { label: "Nombre", name: "Nombre", type: "text" },
            { label: "Apellido", name: "Apellido", type: "text" },
            { label: "Edad", name: "edad", type: "number" },
            { label: "Teléfono", name: "Telefono", type: "text" },
            { label: "E-Mail", name: "Email", type: "email" },
            { label: "Dirección", name: "Direccion", type: "text" }
          ].map(({ label, name, type }) => (
            <div className="mb-3" key={name}>
              <label className="form-label">{label}</label>
              <input
                type={type}
                name={name}
                className="form-control"
                value={contacto[name]} 
                onChange={handleChange}
                placeholder={label}
              />
            </div>
          ))}

          <div className="text-center">
            <button type="button" className="btn btn-submit mt-3" onClick={saveContacto}>
              Enviar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AñadirContacto;
