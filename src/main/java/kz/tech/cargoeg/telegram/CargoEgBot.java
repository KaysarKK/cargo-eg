package kz.tech.cargoeg.telegram;

import kz.tech.cargoeg.model.dto.NewOrderNotificationDTO;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Component
public class CargoEgBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "CargoEgBot";
    private static final String BOT_TOKEN = "7968044148:AAEvQZ7YwBDz5TbS2cGifcPqOhXgosLQ5xw";
    private static final String ADMIN_CHAT_ID = "106689463";
    private static final String EXECUTOR_CHAT_ID = "525967124";
    private static final String FORUM_CHAT_ID = "-1002328139267";

    private static final String CUSTOMER_CHAT_ID = "358728789";
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка нажатий на кнопки
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText(); // Текст сообщения
            Long chatId = update.getMessage().getChatId(); // ID чата

            // Обработка команды
            if (messageText.equalsIgnoreCase("/createForm")) {
                handleCreateFormCommand(chatId);
            } else if (messageText.equalsIgnoreCase("/start")) {
                sendMessage(chatId, "Добро пожаловать! Используйте /createForm, чтобы создать форму.");
            } else if (messageText.equals("/myid")) {
                sendMessage(chatId, "Ваш chatId: " + chatId);
            }
        }
    }

    private void handleCreateFormCommand(Long chatId) {
        // Здесь вы можете реализовать создание формы
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        // Создаем кнопку "Создать отклик" с callbackData
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Создать форму");
        button.setUrl("https://chatgpt.com/");

        List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
        keyboardRow.add(button);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardRow);

        keyboardMarkup.setKeyboard(keyboard);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Для создания заявку, нажмите на кнопку \"Создать форму\"");
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Уведомление исполнителей о новой заявке с кнопкой
    public void notifyExecutors(NewOrderNotificationDTO dto) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        // Создаем кнопку "Создать отклик" с callbackData
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Создать отклик");
        button.setCallbackData("createResponse:" + dto.getOrderId());
        button.setUrl("https://www.algoexpert.io/purchase");

        List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
        keyboardRow.add(button);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardRow);

        keyboardMarkup.setKeyboard(keyboard);
        if (!dto.getExecutorChatIds().isEmpty()) {

            dto.getExecutorChatIds().forEach(s -> {
                SendMessage message = new SendMessage();
                message.setChatId(s);
                message.setText("Новая заявка:\n" + dto.getOrderDescription());
                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            });
        }

        SendMessage message = new SendMessage();
        message.setChatId(FORUM_CHAT_ID);
        message.setText("Новая заявка:\n" + dto.getOrderDescription());
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    // Уведомление админа о новом отклике
    public void notifyAdminAboutResponse(String orderId, Long executorChatId) {
        String text = "Поступил новый отклик на заявку ID: " + orderId + "\nОт пользователя: " + executorChatId;

        SendMessage message = new SendMessage();
        message.setChatId(ADMIN_CHAT_ID);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // Универсальная функция отправки сообщений
    public void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void notifyAdmin(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(ADMIN_CHAT_ID);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void notifyCustomer(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(CUSTOMER_CHAT_ID);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void notifyExecutor(String text) {
        SendMessage message = new SendMessage();
        message.setChatId(EXECUTOR_CHAT_ID);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
