package com.trianasalesianos.edu.TrianaTourist.models.dto;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.validacion.multiple.anotaciones.FieldsValueMatch;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "coverPhoto",
                fieldMatch = "photo2",
                fieldMatch2 = "photo3"
        )
})
public class PointOfInterestDto {

    private String name;
    private String location;
    private String description;
    private LocalDateTime fechaApertura;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private CategoryDto categoria;
}
