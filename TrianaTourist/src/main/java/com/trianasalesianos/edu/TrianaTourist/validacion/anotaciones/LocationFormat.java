package com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones;

import com.trianasalesianos.edu.TrianaTourist.validacion.validadores.LocationFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocationFormatValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocationFormat {

    String message() default "{pointOfInteres.location.format}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String field();
}
