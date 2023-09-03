/*
Esta clase se crea para diferenciar los errores que
tengamos en nuestra lógica del negocio de los errores y bugs
propios del sistema
*/

package com.example.demo.excepciones;

public class MiException extends Exception{
    public MiException(String msg){
        super(msg);
    }
}
