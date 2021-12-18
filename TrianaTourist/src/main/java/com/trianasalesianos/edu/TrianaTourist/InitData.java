package com.trianasalesianos.edu.TrianaTourist;

import com.trianasalesianos.edu.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CategoryService categoryService;

    @PostConstruct
    public void init(){
        /*
        categoryService.save(Category.builder()
                        .name("categoria de prueba")
                .build());
         */
    }

}
