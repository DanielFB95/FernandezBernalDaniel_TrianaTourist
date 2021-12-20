package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.LocationFormat;
import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.PhotosUnique;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@PhotosUnique(coverPhoto = "coverPhoto",photo2 = "photo2",photo3 = "photo3")
@LocationFormat(field = "location")
public class CreatePointOfInterestDto {

    @NotNull(message = "{object.notNull} 'name'")
    private String name;
    private String location;
    @Lob
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime fechaApertura;
    @Lob
    @URL(message = "El formato de la url de la foto es incorrecto")
    @NotNull(message = "{object.notNull} 'coverPhoto'")
    private String coverPhoto;
    @Lob
    @URL(message = "El formato de la url de la foto es incorrecto")
    private String photo2;
    @Lob
    @URL(message = "El formato de la url de la foto es incorrecto")
    private String photo3;
    private int categoria_id;

    public CreatePointOfInterestDto(String name, String location, String description, LocalDateTime fechaApertura, String coverPhoto, String photo2, String photo3) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.fechaApertura = fechaApertura;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }
}
