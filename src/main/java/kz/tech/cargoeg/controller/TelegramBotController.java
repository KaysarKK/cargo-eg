package kz.tech.cargoeg.controller;

import kz.tech.cargoeg.model.dto.NewOrderNotificationDTO;
import kz.tech.cargoeg.telegram.CargoEgBot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/notifications")
public class TelegramBotController {
    private final CargoEgBot telegramBot;

    public TelegramBotController(CargoEgBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @PostMapping("/notifyNewOrder")
    public void notifyNewOrder(@RequestBody NewOrderNotificationDTO dto) {
        telegramBot.notifyExecutors(dto);
    }

    @PostMapping("/notifyNewResponse")
    public void notifyNewResponse(@RequestParam String orderId, @RequestParam Long executorChatId) {
        telegramBot.notifyAdminAboutResponse(orderId, executorChatId);
    }

    @PostMapping("/notifyAdmin")
    public void notifyAdmin(@RequestParam String text) {
        telegramBot.notifyAdmin(text);
    }

    @PostMapping("/notifyCustomer")
    public void notifyCustomer(@RequestParam String text) {
        telegramBot.notifyCustomer(text);
    }

    @PostMapping("/notifyExecutor")
    public void notifyExecutor(@RequestParam String text) {
        telegramBot.notifyExecutor(text);
    }
}
