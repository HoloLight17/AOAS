package ru.ithub.aoas.payload.response;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ClientDto implements Serializable {
    private Long id;

    @NotBlank
    private String fullName;

    @NotBlank
    private Long phoneNumber;

    @Email
    private String email;
}
