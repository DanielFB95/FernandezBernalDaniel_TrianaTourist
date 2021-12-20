package com.trianasalesianos.edu.TrianaTourist.services;

import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.CategoryDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.PointOfInterestDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreatePointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.repositories.PointOfInterestRepository;
import com.trianasalesianos.edu.TrianaTourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PointOfInterestService extends BaseService<PointOfInterest,Long,PointOfInterestRepository> {

    private final PointOfInterestRepository pointOfInterestRepository;
    private final PointOfInterestDtoConverter pointOfInterestDtoConverter;
    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;

    public PointOfInterest findOne(Long id){
        return pointOfInterestRepository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(Long.toString(id),PointOfInterest.class));
    }

    public List<PointOfInterest> findAll(){

        List<PointOfInterest>listaPoints = pointOfInterestRepository.findAll();

        if (listaPoints.isEmpty())
            throw new ListEntityNotFoundException(Point.class);
        else
            return listaPoints;
    }

    public PointOfInterest save(CreatePointOfInterestDto createPointOfInterestDto){

        Category categoria = categoryService.findById(Integer.toUnsignedLong(createPointOfInterestDto.getCategoria_id()))
                .orElse(null);

        if(categoria == null){

            PointOfInterest nuevoPuntoDeInteres = PointOfInterest.builder()
                    .name(createPointOfInterestDto.getName())
                    .location(createPointOfInterestDto.getLocation())
                    .description(createPointOfInterestDto.getDescription())
                    .fechaApertura(createPointOfInterestDto.getFechaApertura())
                    .coverPhoto(createPointOfInterestDto.getCoverPhoto())
                    .photo2(createPointOfInterestDto.getPhoto2())
                    .photo3(createPointOfInterestDto.getPhoto3())
                    .build();

            return pointOfInterestRepository.save(nuevoPuntoDeInteres);

        }else{

            PointOfInterest nuevoPuntoDeInteres = PointOfInterest.builder()
                    .name(createPointOfInterestDto.getName())
                    .location(createPointOfInterestDto.getLocation())
                    .description(createPointOfInterestDto.getDescription())
                    .fechaApertura(createPointOfInterestDto.getFechaApertura())
                    .coverPhoto(createPointOfInterestDto.getCoverPhoto())
                    .photo2(createPointOfInterestDto.getPhoto2())
                    .photo3(createPointOfInterestDto.getPhoto3())
                    .categoria(categoryService.findOne(Integer.toUnsignedLong(createPointOfInterestDto.getCategoria_id())))
                    .build();

            return pointOfInterestRepository.save(nuevoPuntoDeInteres);
        }

    }

    public PointOfInterest edit(Long id, CreatePointOfInterestDto pointOfInterestDto){

        PointOfInterest pointOfInterestEdit = findOne(id);
        pointOfInterestEdit.setName(pointOfInterestDto.getName());
        pointOfInterestEdit.setLocation(pointOfInterestDto.getLocation());
        pointOfInterestEdit.setDescription(pointOfInterestDto.getDescription());
        pointOfInterestEdit.setFechaApertura(pointOfInterestDto.getFechaApertura());
        pointOfInterestEdit.setCoverPhoto(pointOfInterestDto.getCoverPhoto());
        pointOfInterestEdit.setPhoto2(pointOfInterestDto.getPhoto2());
        pointOfInterestEdit.setPhoto3(pointOfInterestDto.getPhoto3());
        pointOfInterestEdit.setCategoria(categoryService.findOne(Integer.toUnsignedLong(pointOfInterestDto.getCategoria_id())));
        return save(pointOfInterestEdit);

    }

    public void delete(PointOfInterest pointOfInterest){

        findOne(pointOfInterest.getId());
        pointOfInterestRepository.delete(pointOfInterest);
    }

}
