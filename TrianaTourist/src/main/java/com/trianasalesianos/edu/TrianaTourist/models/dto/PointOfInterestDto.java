package com.trianasalesianos.edu.TrianaTourist.models.dto;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.PhotosUnique;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
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
