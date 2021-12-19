package com.trianasalesianos.edu.TrianaTourist.repositories;

import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest,Long> {

    boolean existByName(String name);
}
