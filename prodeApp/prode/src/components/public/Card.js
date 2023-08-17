import React from 'react'
import {Link} from 'react-router-dom'

const Card = ({equipo}) => {
  return (
                <div className="col">
                <div className="card shadow-sm">
                  <img width="50%" src={equipo.image} alt="imagen"/>
                  
                  <h3>{equipo.name}</h3>

                  <div className="card-body">
                    <p className="card-text">Esta es una tarjeta más amplia con texto de apoyo a continuación como una introducción natural a contenido adicional. Este contenido es un poco más largo.</p>
                    <div className="d-flex justify-content-between align-items-center">
                      <div className="btn-group">
                        <button type="button" className="btn btn-sm btn-outline-secondary">Ver</button>
                        <button type="button" className="btn btn-sm btn-outline-secondary">
                        <Link to={'/details/${equipo.id}'} className="nav-link">
                          Detalle
                        </Link>
                        </button>
                      </div>
                      <small className="text-muted">9 mins</small>
                    </div>
                  </div>
                </div>
                </div>
              
  )
}

export default Card;
