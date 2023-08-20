import React, {useState} from 'react'


const Footer = () => {

    const [click,setClick] = useState(0);

    const [background,setBackground] = useState('default-background');

    const year = new Date().getFullYear();
    const companyName = "imprenta Socha";

    const handleClick = () => {
        setClick(click+1);
    }

    const handleBackground=()=>{
      setBackground(()=>{
        setBackground(background === 'default-background' ? 'new-background' : 'default-background');
        console.log("no soy quién para andar haciendo mandados")
      })
    }


  return (
    <div className={`app-container ${background}`}>
        <footer className="py-3 my-4">
          <ul className="nav justify-content-center border-bottom pb-3 mb-3">
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Arriba</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Posiciones</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Vaticinios</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">FAQs</a></li>
          <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Acerca</a></li>
        </ul>

        <div className="form-check form-switch">
          <input onClick={handleBackground} className="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault" />
            <label className="form-check-label" for="flexSwitchCheckDefault">Modo nocturno</label>
        </div>

        <p onClick={handleClick} className="text-center text-muted"> {year} {companyName} Clicks={click}</p>


        </footer>
      </div>

  )
}

export default Footer
