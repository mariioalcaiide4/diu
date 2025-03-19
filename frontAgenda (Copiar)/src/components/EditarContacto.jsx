import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import AgendaDataService from "../services/agenda.service";
import Navbar from "./NavBar"; 
import "./AñadirContacto.css";

const EditarContacto = () => {
  const { dni } = useParams(); // Obtener el DNI desde la URL
  const navigate = useNavigate(); // Para redirigir después de actualizar

  const [contacto, setContacto] = useState({
    dni: "",
    nombre: "",
    apellido: "",
    edad: "",
    telefono: "",
    email: "",
    direccion: "",
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


  useEffect(() => {
    AgendaDataService.get(dni)
      .then((response) => {
        setContacto(response.data); // Cargar los datos en el formulario
      })
      .catch((error) => {
        console.error("Error al obtener el contacto:", error);
      });
  }, [dni]);

  // Manejar cambios en los inputs
  const handleChange = (event) => {
    const { name, value } = event.target;
    setContacto((prevContacto) => ({
      ...prevContacto,
      [name]: value
    }));
  };

  // Guardar contacto actualizado en la base de datos
  const updateContacto = () => {
    AgendaDataService.update(dni, contacto)
      .then(() => {
        alert("Contacto actualizado exitosamente!");
        navigate("/"); // Redirigir a la lista de contactos
      })
      .catch((error) => {
        console.error("Error al actualizar el contacto:", error);
      });
  };

  return (
    <div className="container">
      <Navbar />
      <div className="form-container">
        <h2 className="text-center mb-4">Editar Contacto</h2>
        <form>
          {[
            { label: "DNI", name: "dni", type: "text", disabled: true },
            { label: "Nombre", name: "nombre", type: "text" },
            { label: "Apellido", name: "apellido", type: "text" },
            { label: "Edad", name: "edad", type: "number" },
            { label: "Teléfono", name: "telefono", type: "text" },
            { label: "E-Mail", name: "email", type: "email" },
            { label: "Dirección", name: "direccion", type: "text" }
          ].map(({ label, name, type, disabled }) => (
            <div className="mb-3" key={name}>
              <label className="form-label">{label}</label>
              <input
                type={type}
                name={name}
                className="form-control"
                value={contacto[name]} 
                onChange={handleChange}
                placeholder={label}
                disabled={disabled} // Deshabilitar el campo DNI
              />
            </div>
          ))}

          <div className="text-center">
            <button type="button" className="btn btn-primary mt-3" onClick={updateContacto}>
              Actualizar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EditarContacto;
