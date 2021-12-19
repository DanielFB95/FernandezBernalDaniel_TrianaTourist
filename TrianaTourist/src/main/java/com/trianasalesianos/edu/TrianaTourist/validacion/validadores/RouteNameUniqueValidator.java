package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.repositories.RouteRepository;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.RouteNameUnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RouteNameUniqueValidator implements ConstraintValidator<RouteNameUnique,String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(RouteNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return StringUtils.hasText(name) && !routeRepository.existsByName(name);
    }
}
