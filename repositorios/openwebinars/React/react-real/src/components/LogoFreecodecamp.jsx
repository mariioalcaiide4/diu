import Boton from './components/Boton'
import Pantallita from './components/Pantallita'
import Limpiar from './components/Limpiar'
import { useState } from 'react'
import { evaluate } from 'mathjs'
import LogoFreecodecamp from './components/LogoFreecodecamp'

function App() {

    const [input,setInput] = useState('');

    const agregarInput = val =>{
       setInput(input + val);
    }

    const calcularResultado = () =>{
        if(input){
            setInput(evaluate(input));
        }else{
            alert('Ingrese valores');
        }

    }

  return (
    <div className="App">
        <LogoFreecodecamp />
        <div className='contenedor-calculadora'>
            
            <Pantallita input={input} />

            <div className='fila'>
                <Boton manejarClic={agregarInput}>1</Boton>
                <Boton manejarClic={agregarInput}>2</Boton>
                <Boton manejarClic={agregarInput}>3</Boton>
                <Boton manejarClic={agregarInput}>+</Boton>
            </div>
            <div className='fila'>
                <Boton manejarClic={agregarInput}>4</Boton>
                <Boton manejarClic={agregarInput}>5</Boton>
                <Boton manejarClic={agregarInput}>6</Boton>
                <Boton manejarClic={agregarInput}>-</Boton>
            </div>

            <div className='fila'>
                <Boton manejarClic={agregarInput}>7</Boton>
                <Boton manejarClic={agregarInput}>8</Boton>
                <Boton manejarClic={agregarInput}>9</Boton>
                <Boton manejarClic={agregarInput}>*</Boton>
            </div>

            <div className='fila'>
                <Boton manejarClic={calcularResultado}>=</Boton>
                <Boton manejarClic={agregarInput}>0</Boton>
                <Boton manejarClic={agregarInput}>.</Boton>
                <Boton manejarClic={agregarInput}>/</Boton>
            </div>

            <div className='fila'>
                <Limpiar manejarClear = {() => setInput('')}>Clear</Limpiar>
            </div>
        </div>
    </div>
  );
}

export default App;