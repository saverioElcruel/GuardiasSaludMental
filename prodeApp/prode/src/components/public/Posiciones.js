import React, {useEffect,useState} from 'react'
import {Link, useParams, useLocation} from 'react-router-dom'
import RickAndMortyService from '../../services/RickAndMorty.service';

const Posiciones = () => {

    const [equipo, setEquipo] = useState({});
    const {id} = useParams();
    const { pathname } = useLocation(); 

    useEffect(()=>{
        RickAndMortyService.getCharacterById(id)
        .then((data)=>setEquipo(data))
    },[])
    const detailCard = {
        width: '80%',
        margin: 'auto',
        background: 'white'
       }
      
        return (
            <table class="table table-dark table-hover">
            <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Primero</th>
      <th scope="col">Último</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
          </table>
  )
}

export default Posiciones