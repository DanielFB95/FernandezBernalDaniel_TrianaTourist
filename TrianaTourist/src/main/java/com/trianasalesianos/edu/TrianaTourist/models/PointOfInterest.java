package com.trianasalesianos.edu.TrianaTourist.models;

import com.trianasalesianos.edu.TrianaTourist.validacion.anotaciones.PhotosUnique;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class PointOfInterest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime fechaApertura;
    private String coverPhoto;
    private String photo2;
    private String photo3;

    @ManyToOne
    @JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_POI_CATEGORIA"))
    private Category categoria;

    public void addCategoria(Category c){
        categoria = c;
    }

    public void removeCategoria(Category c){
        categoria = null;
    }
}
