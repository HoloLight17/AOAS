package ru.ithub.aoas.payload.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderTypeDto implements Serializable {
    private Long id;
    private String name;
}
