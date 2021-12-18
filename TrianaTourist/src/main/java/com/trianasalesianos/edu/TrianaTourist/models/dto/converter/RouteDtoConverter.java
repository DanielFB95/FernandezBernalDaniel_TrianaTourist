package com.trianasalesianos.edu.TrianaTourist.models.dto.converter;

import com.trianasalesianos.edu.TrianaTourist.models.Route;
import com.trianasalesianos.edu.TrianaTourist.models.dto.RouteDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreateRouteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RouteDtoConverter {

    private final PointOfInterestDtoConverter pointOfInterestDtoConverter;

    public Route createRouteDtoToRoute (CreateRouteDto createRouteDto){

        return Route.builder()
                .name(createRouteDto.getName())
                .build();
    }

    public RouteDto routeToRouteDto(Route route){

        return RouteDto.builder()
                .name(route.getName())
                .pointsOfInterestList(route.getPointsOfInterestList().stream().map(pointOfInterestDtoConverter::pointOfInterestToPointOfInterestDto).collect(Collectors.toList()))
                .build();
    }


}
