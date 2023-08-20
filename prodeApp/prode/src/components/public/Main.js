import React, { Component } from 'react'
import Cards from './Cards';
import {Link} from 'react-router-dom'


export default class Main extends Component {
  
        constructor(props){
            super(props);
            this.state = { equipos: [] };
        }
  
    componentDidMount(){
        
    }
    render() {
    return (
        <div>
        <main>
        <section className="py-5 text-center container">
          <div className="row py-lg-5">
            <div className="col-lg-6 col-md-8 mx-auto">
              <h1 className="fw-light">Pronósticos deportivos</h1>
              <p className="lead text-muted">Elige un partido y haz tus predicciones. Si adivinás la cantidad de goles de cada equipo obtenés 3 puntos. Si solo adivinás quién gana o si hay empate, tenés 1 punto.</p>
              <p>
                <Link to={`/user-form`} className="nav-link">
                          Formulario
                        </Link>
                <a href="#" className="btn btn-secondary my-2">Acción secundaria</a>
              </p>
            </div>
          </div>
        </section>
      </main>


      <Cards />

      </div>
    )
  }
}
