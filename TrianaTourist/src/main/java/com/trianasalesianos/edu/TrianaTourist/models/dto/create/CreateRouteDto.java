package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.RouteNameUnique;
import lombok.*;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateRouteDto {

    @RouteNameUnique
    private String name;

}
