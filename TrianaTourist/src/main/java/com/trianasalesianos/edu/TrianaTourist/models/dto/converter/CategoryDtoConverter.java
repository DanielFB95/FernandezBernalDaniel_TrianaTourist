package com.trianasalesianos.edu.TrianaTourist.models.dto.converter;

import com.trianasalesianos.edu.TrianaTourist.models.Category;
import com.trianasalesianos.edu.TrianaTourist.models.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category categoryDtoToCategory (CategoryDto categoryDto){

        return Category.builder()
                .name(categoryDto.getName())
                .build();
    }

    public CategoryDto categoryToCategoryDto (Category category){
        return CategoryDto.builder()
                .name(category.getName())
                .build();
    }


}
