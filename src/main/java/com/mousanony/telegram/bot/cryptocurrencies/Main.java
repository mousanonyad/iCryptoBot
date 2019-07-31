package com.mousanony.telegram.bot.cryptocurrencies;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author mousanonyad
 */
public class Main {

    private static final String BOT_TOKEN = "";
    private static final String BOT_NAME = "iCryptoBot";
    private static final String PROXY_HOST = "194.167.44.91";
    private static final int PROXY_PORT = 80;

    public static void main(String[] args) {
        try {

            ApiContextInitializer.init();

            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi();

            // Set up Http proxy
            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

            botOptions.setProxyHost(PROXY_HOST);
            botOptions.setProxyPort(PROXY_PORT);
            // Select proxy type: [HTTP|SOCKS4|SOCKS5] (default: NO_PROXY)
            botOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);

            // Register your newly created AbilityBot
            Bot bot = new Bot(BOT_TOKEN, BOT_NAME, botOptions);

            botsApi.registerBot(bot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
