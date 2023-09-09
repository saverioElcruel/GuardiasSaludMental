
package com.example.demo.controladores;

import com.example.demo.excepciones.MiException;
import com.example.demo.servicios.AutorServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/autor") //localhost:8080/autor
public class AutorControlador {
    
    @Autowired
    private AutorServicio autorServicio;
       
    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar(){
        return "autor_form.html";
    }
    
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre) throws MiException{
        
        try {
            
            autorServicio.crearAutor(nombre);
            
//            modelo.put("exito", "El Autor fue registrado correctamente!");
        } catch (MiException ex) {
                      
//            modelo.put("error", ex.getMessage());
            return "autor_form.html";
        }
        
        return "index.html";        
    }
}