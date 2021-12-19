package com.trianasalesianos.edu.TrianaTourist.controllers;

import com.trianasalesianos.edu.TrianaTourist.models.dto.RouteDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.RouteDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreateRouteDto;
import com.trianasalesianos.edu.TrianaTourist.services.RouteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/route")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;

    @GetMapping("/{id}")
    public RouteDto findOne(@PathVariable Long id){
        return routeDtoConverter.routeToRouteDto(routeService.findOne(id));
    }

    @GetMapping("/")
    public List<RouteDto> findAll(){
        return routeService.findAll()
                .stream()
                .map(routeDtoConverter::routeToRouteDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<RouteDto> save(@Valid @RequestBody CreateRouteDto createRouteDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(routeDtoConverter.routeToRouteDto(routeService.save(createRouteDto)));
    }

    @PutMapping("/{id}")
    public RouteDto edit(@Valid @PathVariable Long id, @RequestBody CreateRouteDto createRouteDto){
        return routeDtoConverter.routeToRouteDto(routeService.edit(id,createRouteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        routeService.delete(routeService.findOne(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/agregarPuntoInteres/{id2}")
    public RouteDto addPointOfInterest(@PathVariable Long id, @PathVariable Long id2){
        routeService.addPointOfInterest(id,id2);
        return routeDtoConverter.routeToRouteDto(routeService.findOne(id));
    }

    @PostMapping("/{id}/borrarPuntoInteres/{id2}")
    public RouteDto removePointOfInterest(@PathVariable Long id, @PathVariable Long id2){
       routeService.deletePointOfInterest(id,id2);
        return routeDtoConverter.routeToRouteDto(routeService.findOne(id));
    }
}
