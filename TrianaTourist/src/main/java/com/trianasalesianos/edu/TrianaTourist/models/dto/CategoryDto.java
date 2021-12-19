package com.trianasalesianos.edu.TrianaTourist.models.dto;

import com.trianasalesianos.edu.TrianaTourist.validacion.multiple.anotaciones.FieldsValueMatch;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CategoryDto {

    private String name;

}
