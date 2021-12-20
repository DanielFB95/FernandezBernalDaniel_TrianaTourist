package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.repositories.CategoryRepository;
import com.trianasalesianos.edu.TrianaTourist.repositories.RouteRepository;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.NameUnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameUniqueValidator implements ConstraintValidator<NameUnique,String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(NameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !categoryRepository.existsByName(name) && !routeRepository.existsByName(name);
    }
}
