package ru.ithub.aoas.payload.response;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ithub.aoas.domain.entity.order.OrderStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    private Long id;
    private String information;
    private LocalDateTime createdAt;
    private LocalDateTime doneAt;
    private String orderStatus;
    private Long clientId;
    private Long performerId;
    private Long orderTypeId;

    private Map<Long, Integer> requiredMaterials = new HashMap<>();
}
