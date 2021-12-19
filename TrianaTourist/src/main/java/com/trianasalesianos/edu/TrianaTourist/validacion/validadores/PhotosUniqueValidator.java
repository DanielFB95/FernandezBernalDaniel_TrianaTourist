package com.trianasalesianos.edu.TrianaTourist.validacion.validadores;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.PhotosUnique;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhotosUniqueValidator implements ConstraintValidator<PhotosUnique,Object> {

    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(PhotosUnique constraintAnnotation) {
        this.coverPhoto = constraintAnnotation.coverPhoto();
        this.photo2 = constraintAnnotation.photo2();
        this.photo3 = constraintAnnotation.photo3();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhoto);
        Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);

        if(coverPhotoValue != null){
            return coverPhotoValue.equals(photo2Value) && coverPhotoValue.equals(photo3Value);
        }else{
            return coverPhotoValue == null;
        }

    }

}
