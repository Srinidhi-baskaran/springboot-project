package com.example.task_item.Dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public record CreateItemDto(

        //@NotBlank(message = "Title must be between 1 to 255 characters")
        @Size (min=1,max=255,message =" Name must be between 1 to 255 characters")
        String name,
        @Length(max=1000,message = "Description must be upto 1000 characters")
        @Nullable
        String description


) {


}
