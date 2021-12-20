package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.LocationFormat;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocationFormatValidator implements ConstraintValidator<LocationFormat,Object> {

    private String field;

    @Override
    public void initialize(LocationFormat constraintAnnotation) {
        field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        String fieldValue = (String) PropertyAccessorFactory.forBeanPropertyAccess(s).getPropertyValue(field);
        String formatoLocalizacion = "^[-+]?([1-8]?\\\\d(\\\\.\\\\d+)?|90(\\\\.0+)?),\\\\s*[-+]?(180(\\\\.0+)?|((1[0-7]\\\\d)|([1-9]?\\\\d))(\\\\.\\\\d+)?)$";
        return StringUtils.hasText(fieldValue) && fieldValue.matches(formatoLocalizacion);
    }
}
