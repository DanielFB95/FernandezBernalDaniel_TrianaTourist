package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.NameUnique;
import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateRouteDto {

    @NameUnique
    private String name;

}
