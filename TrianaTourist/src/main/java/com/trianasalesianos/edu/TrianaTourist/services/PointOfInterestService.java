package com.trianasalesianos.edu.TrianaTourist.services;

import com.trianasalesianos.edu.TrianaTourist.models.PointOfInterest;
import com.trianasalesianos.edu.TrianaTourist.repositories.PointOfInterestRepository;
import com.trianasalesianos.edu.TrianaTourist.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PointOfInterestService extends BaseService<PointOfInterest,Long,PointOfInterestRepository> {
}
