package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.repositories.CategoryRepository;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.CategoryNameUnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryNameUniqueValidator implements ConstraintValidator<CategoryNameUnique,String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(CategoryNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !categoryRepository.existsByName(name);
    }
}
