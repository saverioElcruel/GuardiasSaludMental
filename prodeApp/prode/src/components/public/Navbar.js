import React from 'react'
import {Link} from 'react-router-dom'

const Navbar = () => {
  return (
    <div>
      <header className="p-3 bg-dark text-white">
        <div className="container">
          <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li> 
              <Link to={`/`} className="nav-link">
              <a className="nav-link px-2 text-secondary">Inicio</a></ Link>
              </li> 
                
              <li>
              <Link to={`/posiciones`} className="nav-link">
                <a href="#" className="nav-link px-2 text-white">Posiciones</a>
                </Link>
                </li>

              <li><a href="#" className="nav-link px-2 text-white">Vaticinios</a></li>
              <li><a href="#" className="nav-link px-2 text-white">FAQs</a></li>
              <li><a href="#" className="nav-link px-2 text-white">Acerca</a></li>
            </ul>
            <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
              <input type="search" className="form-control form-control-dark" placeholder="Buscar..." aria-label="Buscar"/>
            </form>
            <div className="text-end">
              <button type="button" className="btn btn-outline-light me-2">Ingresar</button>
              <button type="button" className="btn btn-warning">Registrarse</button>
            </div>
          </div>
        </div>
      </header>
    </div>
  )
}

export default Navbar
