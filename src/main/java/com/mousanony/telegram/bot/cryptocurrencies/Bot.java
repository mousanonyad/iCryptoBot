//package com.mousanony.telegram.bot.cryptocurrencies;
//
///**
// * @author mousanonyad
// */
//public class Bot extends AbilityBot {
//
//    protected Bot(String botToken, String botUsername, DefaultBotOptions botOptions) {
//        super(botToken, botUsername, botOptions);
//    }
//
//    public int creatorId() {
//        return 0;
//    }
//
//    public Ability pingPong() {
//        return Ability
//                .builder()
//                .name("ping")
//                .info("ping pong")
//                .locality(ALL)
//                .privacy(PUBLIC)
//                .action(ctx -> silent.send("pong", ctx.chatId()))
//                .build();
//    }
//
//}
