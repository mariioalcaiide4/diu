import React, { useState } from "react";
import AgendaDataService from "../services/agenda.service";
import Navbar from "./NavBar"; 
import "./AñadirContacto.css";

const AñadirContacto = () => {
  const [contacto, setContacto] = useState({
    dni: "",        // Antes: Dni
    nombre: "",     // Antes: Nombre
    apellido: "",   // Antes: Apellido
    edad: "",       
    telefono: "",   // Antes: Telefono
    email: "",      // Antes: Email
    direccion: ""   // Antes: Direccion
  });

  const [errores, setErrores] = useState({});

  // Función para validar el formulario
  const validarFormulario = () => {
    let erroresTemp = {};

    // Validaciones
    if (!contacto.dni.match(/^[0-9]{8,10}[A-Za-z]?$/)) {
      erroresTemp.dni = "DNI inválido (Ej: 12345678X)";
    }
    if (!contacto.nombre.match(/^[A-Za-z\s]+$/)) {
      erroresTemp.nombre = "Solo letras permitidas";
    }
    if (!contacto.apellido.match(/^[A-Za-z\s]+$/)) {
      erroresTemp.apellido = "Solo letras permitidas";
    }
    if (!contacto.edad || contacto.edad < 18 || contacto.edad > 100) {
      erroresTemp.edad = "Edad entre 18 y 100 años";
    }
    if (!contacto.telefono.match(/^[0-9]{9,15}$/)) {
      erroresTemp.telefono = "Número de teléfono inválido";
    }
    if (!contacto.email.match(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)) {
      erroresTemp.email = "Correo inválido";
    }
    if (contacto.direccion.length < 5) {
      erroresTemp.direccion = "Dirección demasiado corta";
    }

    setErrores(erroresTemp);
    return Object.keys(erroresTemp).length === 0;
  };


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
  { label: "DNI", name: "dni", type: "text" },
  { label: "Nombre", name: "nombre", type: "text" },
  { label: "Apellido", name: "apellido", type: "text" },
  { label: "Edad", name: "edad", type: "number" },
  { label: "Teléfono", name: "telefono", type: "text" },
  { label: "E-Mail", name: "email", type: "email" },
  { label: "Dirección", name: "direccion", type: "text" }
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
