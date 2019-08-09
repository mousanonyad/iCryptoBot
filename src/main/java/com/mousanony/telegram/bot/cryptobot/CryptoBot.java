package com.mousanony.telegram.bot.cryptobot;

import com.mousanony.telegram.bot.cryptobot.services.RequestHandler;
import com.mousanony.telegram.bot.cryptobot.services.Response;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

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
                    }
                    silent.send(response.getCoin().toString(), ctx.chatId());

                })
                .build();
    }

}
