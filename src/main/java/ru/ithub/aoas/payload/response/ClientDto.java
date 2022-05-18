package ru.ithub.aoas.payload.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ClientDto implements Serializable {

  private Long id;
  private String fullName;
  private Long phoneNumber;
  private String email;
}
