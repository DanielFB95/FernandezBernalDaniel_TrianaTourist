package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
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