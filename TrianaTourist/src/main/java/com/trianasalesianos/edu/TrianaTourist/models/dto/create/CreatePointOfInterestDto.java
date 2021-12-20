package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.LocationFormat;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.PhotosUnique;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@PhotosUnique(coverPhoto = "coverPhoto",photo2 = "photo2",photo3 = "photo3")
@LocationFormat(field = "location")
public class CreatePointOfInterestDto {

    private String name;
    private String location;
    private String description;
    private LocalDateTime fechaApertura;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private Category categoria;
}
