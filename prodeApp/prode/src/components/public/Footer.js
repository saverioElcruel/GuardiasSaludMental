import React, {useState} from 'react'

export const Footer = () => {

    const [click,setClick] = useState(0);

    const year = new Date().getFullYear();
    const companyName = "imprenta Socha";

    const handleClick = () => {
        setClick(click+1);
    }

  return (
    <div className="container">
        <footer className="py-3 my-4">
          <ul className="nav justify-content-center border-bottom pb-3 mb-3">
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Inicio</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Posiciones</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Vaticinios</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">FAQs</a></li>
            <li className="nav-item"><a href="#" className="nav-link px-2 text-muted">Acerca</a></li>
          </ul>
      
          <p onClick={handleClick} className="text-center text-muted"> {year} {companyName} Clicks={click}</p>
        
   
        </footer>
      </div>

  )
}

export default Footer
