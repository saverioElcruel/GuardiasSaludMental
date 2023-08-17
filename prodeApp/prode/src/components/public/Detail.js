import React, {useEffect,useState} from 'react'
import {Link, useParams, useLocation} from 'react-router-dom'
import RickAndMortyService from '../../services/RickAndMorty.service';

const Detail = () => {

    const [equipo,setEquipo] = useState({});
    const {id} = useParams();
    const { pathname } = useLocation(); 

    useEffect(()=>{
        console.log(pathname)
        RickAndMortyService.getCharacterById(id)
        .then((data)=>setEquipo(data))
    },[id])
    const detailCard = {
        width: '80%',
        margin: 'auto',
        background: 'white'
       }
      
        return (
          <div className="card mb-3" style={{'background': 'gainsboro'}}>
          <div className="row g-0 mt-4 mb-4" style={detailCard}>
            <div className="col-md-3">
              <img src={equipo.image} className="img-fluid rounded-start imgDetalle" alt="img del equipo"/>
            </div>
            <div className="col-md-8 detalleequipo">
              <div className="card-body">
                <h5 className="card-title">{equipo.name}</h5>
                <p className="card-text"><small className=""> Specie: {equipo.species}</small></p>
                <p className="card-text"><small className=""> Status: {equipo.status}</small></p>
                <p className="card-text"><small className=""> Gender: {equipo.gender}</small></p>
                <p className="card-text"><small className=""> Created: {equipo.created}</small></p>
              </div>
              <div className="btn-group" style={{'marginLeft': '15px'}}>
                    <button
                      type="button"
                      className="btn btn-sm btn-outline-secondary"
                    >
                      <Link to={'/'} className="nav-link px-2 text-success">Inicio</Link>
                    </button>
                  </div>
            </div>
          </div>
        </div>
  )
}

export default Detail
