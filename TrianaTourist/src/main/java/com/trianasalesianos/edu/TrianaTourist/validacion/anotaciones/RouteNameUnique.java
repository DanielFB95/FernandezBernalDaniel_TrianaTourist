package com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones;

import com.trianasalesianos.edu.TrianaTourist.validacion.validadores.RouteNameUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = RouteNameUniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface RouteNameUnique {

    String message() default "//properties";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
