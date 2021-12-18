package com.trianasalesianos.edu.TrianaTourist.controllers;

import com.trianasalesianos.edu.TrianaTourist.models.dto.CategoryDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.CategoryDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDtoConverter categoryDtoConverter;
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findOne(@PathVariable Long id){
        return categoryDtoConverter.categoryToCategoryDto(categoryService.findOne(id));
    }

    @GetMapping("/")
    public List<CategoryDto> findAll(){
        return categoryService.findAll().stream().map(categoryDtoConverter::categoryToCategoryDto).collect(Collectors.toList());
    }

    @PostMapping("/")
    public CategoryDto crearCategoria(@RequestBody CategoryDto categoryDto){
        return categoryDtoConverter.categoryToCategoryDto(categoryService.save(categoryDto));
    }

    @PutMapping("/{id}")
    public CategoryDto editarCategoria(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return categoryDtoConverter.categoryToCategoryDto(categoryService.edit(id,categoryDto));
    }

    @DeleteMapping("/{id}")
    public void borrarCategoria(@PathVariable Long id){
        categoryService.delete(categoryService.findOne(id));
    }

}
