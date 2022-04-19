package ru.ithub.aoas.payload.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class MaterialTypeDto implements Serializable {
    private Long id;

    @NotBlank
    private String name;
}
