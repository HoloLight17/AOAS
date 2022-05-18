package ru.ithub.aoas.payload.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDto implements Serializable {

  private Long id;
  private String name;
  private String link;
}
