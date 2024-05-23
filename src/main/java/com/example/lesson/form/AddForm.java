package com.example.lesson.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AddForm {

    @NotEmpty
    @Length(min = 1, max = 50)
    private String name;

    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private Integer price;

}
