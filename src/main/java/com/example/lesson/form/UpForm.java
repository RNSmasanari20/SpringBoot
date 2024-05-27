package com.example.lesson.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpForm {

    @NotNull
    private Integer id;

    @NotEmpty
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private Integer price;

}
