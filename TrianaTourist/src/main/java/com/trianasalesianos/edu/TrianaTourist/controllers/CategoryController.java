package com.trianasalesianos.edu.TrianaTourist.controllers;

import com.trianasalesianos.edu.TrianaTourist.models.dto.CategoryDto;
import com.trianasalesianos.edu.TrianaTourist.models.dto.converter.CategoryDtoConverter;
import com.trianasalesianos.edu.TrianaTourist.models.dto.create.CreateCategoryDto;
import com.trianasalesianos.edu.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
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
    public ResponseEntity<CategoryDto> crearCategoria(@Valid @RequestBody CreateCategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryDtoConverter.categoryToCategoryDto(categoryService.save(categoryDto)));
    }

    @PutMapping("/{id}")
    public CategoryDto editarCategoria(@Valid @PathVariable Long id, @RequestBody CreateCategoryDto categoryDto){
        return categoryDtoConverter.categoryToCategoryDto(categoryService.edit(id,categoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarCategoria(@PathVariable Long id){
        categoryService.delete(categoryService.findOne(id));
        return ResponseEntity.noContent().build();
    }

}
