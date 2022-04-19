package ru.ithub.aoas.payload.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class MaterialDto implements Serializable {
    private Long id;
    private String name;
    private Long materialTypeId;
    private Long producerId;
}
