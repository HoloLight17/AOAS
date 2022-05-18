package ru.ithub.aoas.payload.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Long orderTypeId;

    private Map<Long, Integer> requiredMaterials = new HashMap<>();
}
