//package com.mousanony.telegram.bot.cryptocurrencies;
//
///**
// * @author mousanonyad
// */
//public class Main {
//
//    public static final String BOT_TOKEN;
//    public static final String BOT_NAME;
//
//    public static void main(String[] args) {
//        try {
//
//            ApiContextInitializer.init();
//
//            // Create the TelegramBotsApi object to register your bots
//            TelegramBotsApi botsApi = new TelegramBotsApi();
//
//            // Set up Http proxy
//            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//
//            botOptions.setProxyHost(PROXY_HOST);
//            botOptions.setProxyPort(PROXY_PORT);
//            // Select proxy type: [HTTP|SOCKS4|SOCKS5] (default: NO_PROXY)
//            botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
//
//            // Register your newly created AbilityBot
//            Bot bot = new Bot(BOT_TOKEN, BOT_NAME, botOptions);
//
//            botsApi.registerBot(bot);
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//}
