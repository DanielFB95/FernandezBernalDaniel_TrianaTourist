package com.trianasalesianos.edu.TrianaTourist.controllers;

import com.trianasalesianos.edu.TrianaTourist.models.dto.PointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.PointOfInterestDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreatePointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.services.PointOfInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pointOfInterest")
@RequiredArgsConstructor
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;
    private final PointOfInterestDtoConverter pointOfInterestDtoConverter;

    @GetMapping("/{id}")
    public PointOfInterestDto findOne(@PathVariable Long id){
        return pointOfInterestDtoConverter
                .pointOfInterestToPointOfInterestDto(pointOfInterestService.findOne(id));
    }

    @GetMapping("/")
    public List<PointOfInterestDto> findAll(){
        return pointOfInterestService.findAll().stream()
                .map(pointOfInterestDtoConverter::pointOfInterestToPointOfInterestDto).collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<PointOfInterestDto> crearPuntoDeInteres(@RequestBody CreatePointOfInterestDto createPointOfInterestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pointOfInterestDtoConverter
                        .pointOfInterestToPointOfInterestDto(pointOfInterestService.save(createPointOfInterestDto)));
    }

    @PutMapping("/{id}")
    public PointOfInterestDto editarPuntoDeInteres(@PathVariable Long id, @RequestBody CreatePointOfInterestDto pointOfInterestDto){
        return pointOfInterestDtoConverter.pointOfInterestToPointOfInterestDto(pointOfInterestService.edit(id,pointOfInterestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pointOfInterestService.delete(pointOfInterestService.findOne(id));
        return ResponseEntity.noContent().build();
    }


}
