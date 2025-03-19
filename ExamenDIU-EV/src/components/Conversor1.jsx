import React, { useState, useEffect } from "react";
import "./Conversor1.css";
import MonedaList from "./MostrarMonedas";
import MonedaDataService from "../services/moneda.service";
import { Form, Button, Card, Col, Row, Container, ProgressBar, Table } from "react-bootstrap";


export default function Conversor1() {
  // Estados
  const [monedas, setMonedas] = useState([]); // Lista de productos
  const [monedaSeleccionada, setMonedaSeleccionada] = useState(null); // Producto de origen
  const [progress, setProgress] = useState(0);
  const [currentMoneda, setCurrentMoneda] = useState(null);
  const [currentIndex, setCurrentIndex] = useState(-1);
  const [eurValue, setEurValue] = useState(""); // Valor ingresado en euros
  const [currencyValue, setCurrencyValue] = useState(""); // Valor ingresado en otra moneda
  
  // Obtiene los productos al montar el componente
  useEffect(() => {
    retrieveMoneda();
    
  }, []);

  const retrieveMoneda =() => {
    MonedaDataService.findAll()
    .then(response => {
      setMonedas(response.data);
      updateProgress(response.data.length);

    })
    .catch(e => {
      console.log(e);
    });
  }

  const updateProgress = (count) => {
    const maxMonedas = 100;
    setProgress(Math.min((count / maxMonedas) * 100, 100));
  };

  const refreshList = () => {
    retrieveMoneda();
    setCurrentMoneda(null);
    setCurrentIndex(-1);
  };

  const setActiveproducto = (moneda, index) => {
    setCurrentMoneda(moneda);
    setCurrentIndex(index);
  };

  // Maneja la conversión de moneda
  const handleConvert = () => {
    if (!monedaSeleccionada) return; // No hace nada si no hay moneda seleccionada

    if (monedaSeleccionada.name.toLowerCase() === "euros") {
      setCurrencyValue(eurValue);
      return;
    }

    if (eurValue) {
      setCurrencyValue((parseFloat(eurValue) * monedaSeleccionada.price));
    } else if (currencyValue) {
      setEurValue((parseFloat(currencyValue) / monedaSeleccionada.price));
    }
  };

  // Maneja cambios en el input de euros
  const handleEurChange = (e) => {
    const value = e.target.value;
    if (value === "" || parseFloat(value) >= 0) { // Evita valores negativos
      setEurValue(value);
      setCurrencyValue(""); // Borra el valor en la otra moneda al ingresar en euros
    }
  };

  // Maneja cambios en el input de otra moneda
  const handleCurrencyChange = (e) => {
    const value = e.target.value;
    if (value === "" || parseFloat(value) >= 0) { // Evita valores negativos
      setCurrencyValue(value);
      setEurValue(""); // Borra el valor en euros al ingresar en otra moneda
    }
  };

  const handleConversion = (e) => {
    const value = handleEurChange * monedaSeleccionada.price;
  }


  return (
    <div className="conversor-container">
      <h3>Conversor de monedas</h3>

      {/* Tabla para seleccionar la moneda de origen */}
      <div className="tables-container">
        <MonedaList
          monedas={monedas}
          onSelect={setMonedaSeleccionada}
          selected={monedaSeleccionada}
        />
      </div>

      <div>
        <h4 className="text-center">Progreso de producto</h4>
        <ProgressBar now={progress} label={`${Math.round(progress)}%`} />
      </div>

      {/* Inputs para ingresar valores */}
      <div className="input-container">
        <div className="input-group">
          <label htmlFor="eur">Cantidad:</label>
          <input
            type="number"
            id="eur"
            value={eurValue}
            min="0"
            onChange={handleEurChange} // Actualiza el estado al escribir en el input
          />
        </div>

        <div className="input-group">
          <label htmlFor="currency">
            {monedaSeleccionada ? monedaSeleccionada.name : "Equivalencia"}:
          </label>
          <input
            type="number"
            id="currency"
            value={currencyValue}
            min="0"
            onChange={handleConversion} // Actualiza el estado al escribir en el input
          />
        </div>
      </div>
    </div>
  );
}
