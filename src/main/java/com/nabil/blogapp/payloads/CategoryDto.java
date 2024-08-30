package com.nabil.blogapp.payloads;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
    private int id;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryDesc;
}
