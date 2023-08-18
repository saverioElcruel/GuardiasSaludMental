import React, {useState, useEffect} from 'react'
import Card from './Card'
import RickAndMortyService from '../../services/RickAndMorty.service';


const Cards = ( {} ) => {

  const [equipos, setEquipos] = useState([]);

  useEffect(()=>{

      RickAndMortyService.getAllCharacters()
        .then((data)=> setEquipos(data.results))
        .catch((error)=> console.log(error));
        
  }, [equipos])

  const cardList = equipos.map((e)=> <Card equipo={e} key={e.id} />)

  return (
      <div>
          {cardList}
      </div>


  )
}

export default Cards
