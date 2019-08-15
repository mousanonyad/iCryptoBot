package com.mousanony.telegram.bot.cryptobot;

import com.mousanony.telegram.bot.cryptobot.services.RequestHandler;
import com.mousanony.telegram.bot.cryptobot.services.Response;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

/**
 * @author mousanonyad
 */
public class CryptoBot extends AbilityBot {

    private RequestHandler requestHandler;

    CryptoBot(String botToken, String botUsername) {
        super(botToken, botUsername);
        requestHandler = new RequestHandler();
    }

    public int creatorId() {
        return 11274465;
    }

    public Ability getCryptoInfo() {
        return Ability
                .builder()
                .name(DEFAULT)
                .info("getCryptoInfo")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> {
                    Response response = requestHandler.parseStringMessage(ctx.update().getMessage());

                    if (response.isError()) {
                        silent.send(response.getError(), ctx.chatId());
                    } else {
                        try {
                            sender.execute(new SendMessage()
                                    .setChatId(ctx.chatId())
                                    .setParseMode(ParseMode.MARKDOWN)
                                    .setText(response.getCoin().toString())
                                    .setReplyMarkup(withButtons(response)));
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .build();
    }

    private ReplyKeyboard withButtons(Response response) {
        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        row.add(response.getCoin().getSymbol() + " " + response.getCoin().getTargetCoin());

        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
}
