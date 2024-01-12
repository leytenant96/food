package org.example.bot;

import org.example.entity.Order;
import org.example.entity.User;
import org.example.service.UserService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class ApplicationBot extends TelegramLongPollingBot {

    private final String botName = "uz_test1food_bot";
    private final String botToken = "6582535984:AAH2JqKV-uV6S4q9qlzFSW1NB1mXqbSkIe8";

    @Override
    public String getBotUsername() {
        return this.botName;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }


    List<Order> orders = new ArrayList<>();
    UserService userService = new UserService();
    KeyboardBTN btn = new KeyboardBTN();


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage() != null) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();

            User user = userService.findByChatId(chatId);

            if (user == null) {
                userService.saveUser(chatId);
                user = userService.findByChatId(chatId);
            }
            if (message.hasText()) {
                String text = message.getText();
                if (text.equals("/start") && user.getPhoneNumber() == null) {
                    send("Bizning botga xush kelibsiz", chatId, btn.phoneNumberBTN());
                } else if (text.equals("/star")) {
                    send("Bosh saxifa", chatId, btn.getHomeBTN());
                }
            }
        }
    }

    public void send(String text, Long chatId, ReplyKeyboardMarkup markup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(markup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String text, Long chatId, InlineKeyboardMarkup markup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(markup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
