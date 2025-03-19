import React, { useState, useEffect } from 'react'
import MonedaDataService from "../services/moneda.service";
import "./MostrarMonedas.css";

const MonedaList = () => {
  const [monedas, setMonedas] = useState([]);  // Lista de clientes
  const [monedaSeleccionada, setMonedaSeleccionada] = useState(null); // Cliente seleccionado

  // Obtener datos de la API al montar el componente
  useEffect(() => {
    recibirMonedas();
  }, []);

  const recibirMonedas = async () => {
    try {
      const response = await MonedaDataService.findAll();
      setMonedas(response.data);
    } catch (error) {
      console.error(" Error al obtener las monedas:", error);
    }
  };

  return (
    <div className="lista">
      {/* 📌 Sección izquierda: Lista de clientes */}
      <div className="col-md-4">
        <h4>Monedas</h4>
        <table className="table-responsive table table-hover table-striped table-bordered table-dark">
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Descripción</th>
              <th>Stock</th>
            </tr>
          </thead>
          <tbody>
            {monedas.length > 0 ? (
              monedas.map((moneda, index) => (
                <tr
                  key={index}
                  className={moneda === monedaSeleccionada ? "active" : ""}
                  onClick={() => setMonedaSeleccionada(moneda)}
                  style={{ cursor: "pointer" }}
                >
                  <td>{moneda.name}</td>
                  <td>{moneda.brand}</td>
                  <td>{moneda.stock}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="2">No hay monedas...</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>  
    </div>
  );
};

export default MonedaList;