package com.mousanony.telegram.bot.cryptocurrencies;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

/**
 * @author mousanonyad
 */
public class Bot extends AbilityBot {

    protected Bot(String botToken, String botUsername, DefaultBotOptions botOptions) {
        super(botToken, botUsername, botOptions);
    }

    public int creatorId() {
        return 0;
    }

    public Ability pingPong() {
        return Ability
                .builder()
                .name("ping")
                .info("ping pong")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("pong", ctx.chatId()))
                .build();
    }

}
