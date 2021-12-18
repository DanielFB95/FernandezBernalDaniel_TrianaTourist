package com.trianasalesianos.edu.TrianaTourist.errors.exceptions;

public class ListEntityNotFoundException extends EntityNotFoundException{

    public ListEntityNotFoundException(Class clazz) {
        super(String.format("No se han podido encontrar elementos del tipo %s.",clazz.getName()));
    }
}
