package com.trianasalesianos.edu.TrianaTourist.repositories;

import com.trianasalesianos.edu.TrianaTourist.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {

    boolean existsByName(String name);
}
