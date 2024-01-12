package org.example;

import org.example.bot.ApplicationBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        try {
            TelegramBotsApi botsApi=new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new ApplicationBot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}