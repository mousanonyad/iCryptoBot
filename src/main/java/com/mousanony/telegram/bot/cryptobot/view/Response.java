package com.mousanony.telegram.bot.cryptobot.view;

import com.mousanony.telegram.bot.cryptobot.dto.ICoin;

/**
 * @author mousanonyad
 */
public class Response {
    private String error;
    private ICoin coin;

    public Response withError(String error) {
        this.error = error;
        return this;
    }

    public String getError() {
        return error;
    }

    public Response withCoin(ICoin coin) {
        this.coin = coin;
        return this;
    }

    public ICoin getCoin() {
        return coin;
    }

    public boolean isError() {
        return error != null;
    }

}
