package com.trianasalesianos.edu.TrianaTourist.models.dto.create;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateCategoryDto {

    @NotNull
    private String name;

}
