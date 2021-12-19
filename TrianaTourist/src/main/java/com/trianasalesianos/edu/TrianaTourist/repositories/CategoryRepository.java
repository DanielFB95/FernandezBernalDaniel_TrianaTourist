package com.trianasalesianos.edu.TrianaTourist.repositories;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    boolean existByName(String name);
}
