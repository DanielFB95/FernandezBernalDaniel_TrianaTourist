package com.trianasalesianos.edu.TrianaTourist.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaApertura;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private CategoryDto categoria;
}
