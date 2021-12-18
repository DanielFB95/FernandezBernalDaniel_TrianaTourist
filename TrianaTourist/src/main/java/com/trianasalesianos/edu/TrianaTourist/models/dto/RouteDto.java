package com.trianasalesianos.edu.TrianaTourist.models.dto;

import lombok.*;

import java.util.List;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RouteDto {

    private String name;
    private List<PointOfInterestDto> pointsOfInterestList;
}
