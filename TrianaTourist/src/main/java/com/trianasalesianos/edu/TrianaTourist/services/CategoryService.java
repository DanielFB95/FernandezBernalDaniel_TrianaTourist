package com.trianasalesianos.edu.TrianaTourist.services;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.repositories.CategoryRepository;
import com.trianasalesianos.edu.TrianaTourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category,Long, CategoryRepository> {

    private final CategoryRepository categoryRepository;

    public Category findOne(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }

    public List<Category> findAll(){

        List<Category> listaCategorias = categoryRepository.findAll();
        if(listaCategorias.isEmpty()){
            return //Excepcion;
        }else{
            return categoryRepository.findAll();
        }
    }

    public Category save(Category category){
        //Excepciones
        categoryRepository.save(category);
        return category;
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }

}
