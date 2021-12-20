package com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.validacion.validadores.CategoriaExistenteValidador;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoriaExistenteValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface CategoriaExistente {

    String message() default "{pointOfInterest.categoria.existe}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int category_id();

}
