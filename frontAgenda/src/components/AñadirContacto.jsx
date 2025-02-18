import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import AgendaDataService from "../services/agenda.service";

const AñadirContacto = () => {
    const navigate = useNavigate();
    const [dni, setDni] = useState('');
    const [nombre, setNombre] = useState('');
    const [apellido, setApellido] = useState('');
    const [edad, setEdad] = useState('');
    const [telefono, setTelefono] = useState('');
    const [email, setEmail] = useState('');

    const handleChange = (e) => {
        console.log(e.target);
        const { name, value } = e.target;
        if (name === "Dni") setDni(value);
        if (name === "Nombre") setNombre(value);
        if (name === "Apellido") setApellido(value);
        if (name === "Edad") setEdad(value);
        if (name === "Telefono") setTelefono(value);
        if (name === "Email") setEmail(value);
      };

      const handleSubmit = async (event) => {
        event.preventDefault(); // Evita que la página se recargue
      
        // Crea el objeto con los datos del formulario
        const contactData = {
            dni: dni,
            nombre: nombre,
            apellido: apellido,
            edad: edad,
            direccion: direccion,
            telefono: telefono,
            email: email,
        };
    }
}    

export default AñadirContacto;
