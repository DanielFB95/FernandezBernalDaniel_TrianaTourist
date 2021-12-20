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

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name="points_interest_id",
                                    foreignKey = @ForeignKey(name="FK_ROUTE_POINTOFINTEREST_ID")),
        inverseJoinColumns = @JoinColumn(name="route_id",
                                    foreignKey = @ForeignKey(name="FK_ROUTE_ROUTE_ID")),
            name = "asignacionRutas"
    )
    @UniqueElements
    private List<PointOfInterest> pointsOfInterestList;

    public Route(String name) {
        this.name = name;
    }

}
