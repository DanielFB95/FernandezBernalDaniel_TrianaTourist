package com.trianasalesianos.edu.TrianaTourist.models.dto.converter;

import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import com.trianasalesianos.edu.TrianaTourist.models.dto.PointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreatePointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PointOfInterestDtoConverter {

    private final CategoryDtoConverter categoryDtoConverter;

    /* Veo raro llamar aqui al servicio de categoria asi que he decidido hacerlo directamente en el servicio de POI

    private final CategoryService categoryService;

    public PointOfInterest createPointOfInterestDtoToPointOfInterest(CreatePointOfInterestDto createPointOfInterestDto){

        return PointOfInterest.builder()
                .name(createPointOfInterestDto.getName())
                .location(createPointOfInterestDto.getLocation())
                .description(createPointOfInterestDto.getDescription())
                .fechaApertura(createPointOfInterestDto.getFechaApertura())
                .coverPhoto(createPointOfInterestDto.getCoverPhoto())
                .categoria(categoryService.findOne(createPointOfInterestDto.getCategoria_id()))
                .photo2(createPointOfInterestDto.getPhoto2())
                .photo3(createPointOfInterestDto.getPhoto3())
                .build();
    }
    */


    public PointOfInterestDto pointOfInterestToPointOfInterestDto (PointOfInterest pointOfInterest){

        return PointOfInterestDto.builder()
                .name(pointOfInterest.getName())
                .location(pointOfInterest.getLocation())
                .description(pointOfInterest.getDescription())
                .fechaApertura(pointOfInterest.getFechaApertura())
                .categoria(categoryDtoConverter.categoryToCategoryDto(pointOfInterest.getCategoria()))
                .coverPhoto(pointOfInterest.getCoverPhoto())
                .photo2(pointOfInterest.getPhoto2())
                .photo3(pointOfInterest.getPhoto3())
                .build();
    }


}
