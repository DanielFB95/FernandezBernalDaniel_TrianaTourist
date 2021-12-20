package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import com.trianasalesianos.edu.TrianaTourist.services.CategoryService;
import com.trianasalesianos.edu.TrianaTourist.services.PointOfInterestService;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.CategoriaExistente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CategoriaExistenteValidador implements ConstraintValidator<CategoriaExistente,Object> {

    private final PointOfInterestService pointOfInterestService;
    private final CategoryService categoryService;

    private int category_id;

    @Override
    public void initialize(CategoriaExistente constraintAnnotation) {
        category_id = constraintAnnotation.category_id();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        //int category = PropertyAccessorFactory.forBeanPropertyAccess(value).get;

        return false;
    }
}
