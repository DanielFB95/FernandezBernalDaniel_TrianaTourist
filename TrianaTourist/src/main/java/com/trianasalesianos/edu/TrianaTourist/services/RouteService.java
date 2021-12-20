package com.trianasalesianos.edu.TrianaTourist.services;

import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import com.trianasalesianos.edu.TrianaTourist.models.Route;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.PointOfInterestDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.RouteDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreatePointOfInterestDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreateRouteDto;
import com.trianasalesianos.edu.TrianaTourist.repositories.RouteRepository;
import com.trianasalesianos.edu.TrianaTourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route,Long, RouteRepository> {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;
    private final PointOfInterestService pointOfInterestService;
    private final PointOfInterestDtoConverter pointOfInterestDtoConverter;

    public Route findOne(Long id){
        return routeRepository.findById(id)
                .orElseThrow(()-> new SingleEntityNotFoundException(Long.toString(id),Route.class));
    }

    public List<Route> findAll(){

        List<Route> listaRutas = routeRepository.findAll();

        if(listaRutas.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else{
            return listaRutas;
        }
    }

    public Route save(CreateRouteDto createRouteDto){
        return routeRepository.save(routeDtoConverter
                .createRouteDtoToRoute(createRouteDto));
    }

    public Route edit(Long id,CreateRouteDto createRouteDto){
        Route rutaEditada = findOne(id);
        rutaEditada.setName(createRouteDto.getName());
        return save(rutaEditada);
    }

    public void delete(Route route){
        findOne(route.getId());
        routeRepository.delete(route);
    }

    public Route addPointOfInterest(Long id,Long id2){

        Route ruta = findOne(id);
        PointOfInterest puntoInterés = pointOfInterestService.findOne(id2);
        List<PointOfInterest> listaPuntosInteres = ruta.getPointsOfInterestList();
        listaPuntosInteres.add(puntoInterés);
        ruta.setPointsOfInterestList(listaPuntosInteres);
        routeRepository.save(ruta);
        return ruta;
    }

    public Route deletePointOfInterest(Long id,Long id2){

        Route ruta = findOne(id);
        PointOfInterest puntoInterés = pointOfInterestService.findOne(id2);
        List<PointOfInterest>listaPuntosInteres = ruta.getPointsOfInterestList();
        listaPuntosInteres.remove(puntoInterés);
        ruta.setPointsOfInterestList(listaPuntosInteres);
        routeRepository.save(ruta);

        return ruta;
    }
}
