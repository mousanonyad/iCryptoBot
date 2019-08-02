package com.mousanony.telegram.bot.cryptobot.services;

import com.mousanony.telegram.bot.cryptobot.dto.Coin;

/**
 * @author mousanonyad
 */
public class Response {
    private String error;
    private Coin coin;

    public Response withError(String error) {
        this.error = error;
        return this;
    }

    public String getError() {
        return error;
    }

    public Response withCoin(Coin coin) {
        this.coin = coin;
        return this;
    }

    public Coin getCoin() {
        return coin;
    }

    public boolean isError() {
        return error != null;
    }

}
