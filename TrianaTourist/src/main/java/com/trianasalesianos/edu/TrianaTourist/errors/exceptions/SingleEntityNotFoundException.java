package com.trianasalesianos.edu.TrianaTourist.errors.exceptions;

import java.util.function.Supplier;

public class SingleEntityNotFoundException extends EntityNotFoundException {


    public SingleEntityNotFoundException(String id,Class clazz) {
        super(String.format("No se ha encontrado ningún objeto del tipo %s con el ID %s",clazz.getName(),id));
    }

}
