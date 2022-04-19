package ru.ithub.aoas.payload.response;

import lombok.Data;
import ru.ithub.aoas.domain.entity.order.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class OrderDto implements Serializable {
    private Long id;
    private String information;
    private LocalDateTime createdAt;
    private LocalDateTime doneAt;
    private OrderStatus orderStatus;
    private Long clientId;
    private Long performerId;
    private Long orderTypeId;

    private Map<Long, Integer> requiredMaterials;
}
