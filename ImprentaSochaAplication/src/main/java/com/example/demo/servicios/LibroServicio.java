
package com.example.demo.servicios;

import com.example.demo.entidades.Autor;
import com.example.demo.entidades.Editorial;
import com.example.demo.entidades.Libro;
import com.example.demo.excepciones.MiException;
import com.example.demo.repositorio.AutorRepositorio;
import com.example.demo.repositorio.EditorialRepositorio;
import com.example.demo.repositorio.LibroRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio {
    
//    @Autowired
    private LibroRepositorio libroRepositorio;
    
//    @Autowired
    private AutorRepositorio autorRepositorio;
    
//    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Autor autor = autorRepositorio.findById(idAutor).get();
        
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        
        libro.setAlta(new Date());
        
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        libroRepositorio.save(libro);
    }
    
    public List<Libro> listarLibros(){
        List<Libro> libros = new ArrayList();
        libros = libroRepositorio.findAll();
        return libros;
    }
    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException{
        /// Libro libro = libroRepositorio.findById(isbn).get();
        
        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Optional<Libro> respuesta = libroRepositorio.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        
        Autor autor = new Autor();
        Editorial editorial = new Editorial();
        
        if(respuestaAutor.isPresent()){
            autor = respuestaAutor.get();
        }
        if(respuestaEditorial.isPresent()){
            editorial = respuestaEditorial.get();
        }
        if(respuesta.isPresent()){
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);
            libroRepositorio.save(libro);
        }
        
        
    }
    
    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        if(isbn == null){
            throw new MiException("El isbn no puede ser nulo");
        }
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no puede ser nulo o estar vacío");
        }
        if(ejemplares == null){
            throw new MiException("Los ejemplares no pueden ser nulos");
        }
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("El autor no puede ser nulo o estar vacío");
        }
        if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("La editorial no puede ser nula o estar vacía");
        }
    }
}
