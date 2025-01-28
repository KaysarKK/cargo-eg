package kz.tech.cargoeg.model.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@Getter
public class NewOrderNotificationDTO {

    private String orderId;
    private String orderDescription;
    private List<String> executorChatIds;

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public List<String> getExecutorChatIds() {
        return executorChatIds;
    }

    public void setExecutorChatIds(List<String> executorChatIds) {
        this.executorChatIds = executorChatIds;
    }
}
