package com.trianasalesianos.edu.TrianaTourist.models;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Route implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = {CascadeType.REMOVE})
    @UniqueElements
    private List<PointOfInterest> pointsOfInterestList;

    public Route(String name) {
        this.name = name;
    }

    public void addPointOfInterest(PointOfInterest pointOfInterest){
        pointsOfInterestList.add(pointOfInterest);
    }

    public void removePointOfInterest(PointOfInterest pointOfInterest){
        pointsOfInterestList.remove(pointOfInterest);
    }
}
