package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.CategoryNameUnique;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateCategoryDto {

    @NotNull
    @CategoryNameUnique
    private String name;

}
