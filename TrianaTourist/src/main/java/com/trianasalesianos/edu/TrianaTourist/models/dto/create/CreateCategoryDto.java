package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.NameUnique;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateCategoryDto {

    @NotNull(message = "{object.notNull} 'name'")
    @NameUnique
    private String name;

}
