import 'bootstrap/dist/css/bootstrap.min.css'; // Importa Bootstrap
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MonedaList from './components/MostrarMonedas';
import Conversor1 from './components/Conversor1';

function App() {
  return (
    <>
      <Conversor1 />
    </>
  )
}

export default App;
