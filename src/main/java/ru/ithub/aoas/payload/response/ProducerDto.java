package ru.ithub.aoas.payload.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ProducerDto implements Serializable {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String link;
}
