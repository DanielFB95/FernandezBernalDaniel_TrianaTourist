package com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones;

import com.trianasalesianos.edu.TrianaTourist.validacion.validadores.CategoryNameUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CategoryNameUniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface CategoryNameUnique {

    String message() default "//properties";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
