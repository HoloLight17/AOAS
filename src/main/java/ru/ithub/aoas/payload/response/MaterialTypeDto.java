package ru.ithub.aoas.payload.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MaterialTypeDto implements Serializable {

  private Long id;
  private String name;
}
