package com.trianasalesianos.edu.TrianaTourist.errors.exceptions;

public class CategoryNotFoundException extends EntityNotFoundException{

    public CategoryNotFoundException(Class clazz) {
        super(String.format("La categoria que ha introducido no existe."));
    }
}
