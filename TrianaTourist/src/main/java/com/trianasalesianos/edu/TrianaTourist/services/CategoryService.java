package com.trianasalesianos.edu.TrianaTourist.services;

import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.models.dto.CategoryDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.CategoryDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.repositories.CategoryRepository;
import com.trianasalesianos.edu.TrianaTourist.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category,Long, CategoryRepository> {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public Category findOne(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(Long.toString(id),Category.class));
    }

    public List<Category> findAll(){

        List<Category>listaCategorias = categoryRepository.findAll();

        if(listaCategorias.isEmpty()){
            throw new ListEntityNotFoundException(Category.class);
        }else{
            return listaCategorias;
        }
     }

    public Category save(CategoryDto category){

        return categoryRepository.save(categoryDtoConverter.categoryDtoToCategory(category));
    }

    public Category edit (Long id,CategoryDto category){
        Category categoriaEditada = findOne(id);
        categoriaEditada.setName(category.getName());
        return save(categoriaEditada);
    }

    public void delete(Category category){
        findOne(category.getId());
        categoryRepository.delete(category);
    }

    public void deleteById(Category category){categoryRepository.deleteById(category.getId());}
}
