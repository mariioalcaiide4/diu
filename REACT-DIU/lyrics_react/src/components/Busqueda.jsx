import React, { useState } from 'react'

function Busqueda() {
    
    const [artista, setArtist] = useState("");
    const [cancion, setCancion] = useState("");
    const [error, setError] = useState(null);
    const [letra, setLetra] = useState(null);

    const buscarCanción = async () => {

        if(!artista || !cancion){
           setError("Complete ambos campos");
           return; 
        }
    
        setError(null);

        try {
            const response = await fetch(`https://api.lyrics.ovh/v1/${artista}/${cancion}`);
        if (!response.ok){
            throw new error("No se encontró la canción")
        }

        const data = response.json()
        setLetra(data.letra);

        } catch (err1){
            setError("")
            console.error(err1)
        } 
    };

    
  
    return (
    <div>
      <h1>BUSCADOR DE CANCIONES</h1>
        <div>
           <label>
            Artista
            <input 
                type="text"
                value={artista}
                onChange={(e) => setArtist(e.target.value)}/>
            </label>        
        </div>  
        <div>      
            <label>
            Canción
            <input 
                type="text"
                value={cancion}
                onChange={(e) => setCancion(e.target.value)}/>
            </label>
        </div>
        <button onClick={buscarCanción}>Buscar Canción</button>
        <br></br>
        <pre>{letra}</pre>
    </div>

    )
}

export default Busqueda
