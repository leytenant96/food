package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardBTN {

    //get Phone Number
    public ReplyKeyboardMarkup phoneNumberBTN() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("Raqamni Yuborish");
        button.setRequestContact(true);

        row.add(button);
        rows.add(row);

        markup.setKeyboard(rows);
        return markup;
    }

    // GET HOME MENU
    public InlineKeyboardMarkup getHomeBTN() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Menu");
        button.setCallbackData("MENU");
        row.add(button);

        button = new InlineKeyboardButton();
        button.setText("Savatcha");
        button.setCallbackData("SAVAT");
        row.add(button);
        rows.add(row);

        button = new InlineKeyboardButton();
        button.setText("Ma'lumot");
        button.setCallbackData("INFO");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }
}
