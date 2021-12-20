package com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones;

import com.trianasalesianos.edu.TrianaTourist.validacion.validadores.PhotosUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhotosUniqueValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhotosUnique {

    String message() default "{pointOfInterest.photo.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String coverPhoto();
    String photo2();
    String photo3();

}
