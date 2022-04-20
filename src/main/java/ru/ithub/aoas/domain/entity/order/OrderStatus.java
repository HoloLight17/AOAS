package ru.ithub.aoas.domain.entity.order;

import java.util.Locale;
import ru.ithub.aoas.exceptions.NotFoundException;

public enum OrderStatus {
  QUEUED,
  DIAGNOSIS,
  WIP,
  DONE;

  public static OrderStatus getByName(String orderStatus) {
    for (OrderStatus n: values()) {
      if(n.name().toLowerCase(Locale.ROOT).trim().equals(orderStatus.toLowerCase(Locale.ROOT).trim())) {
        return n;
      }
    }

    throw new NotFoundException(OrderStatus.class, orderStatus);
  }
}
