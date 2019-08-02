package com.mousanony.telegram.bot.cryptobot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author mousanonyad
 */
public class Application {

    private static final String BOT_TOKEN = "";
    private static final String BOT_NAME = "iCryptoBot";

    public static void main(String[] args) {
        try {

            ApiContextInitializer.init();

            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi();

            // Register your newly created AbilityBot
            CryptoBot bot = new CryptoBot(BOT_TOKEN, BOT_NAME);

            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            //TODO logging
            e.printStackTrace();
        }
    }
}
