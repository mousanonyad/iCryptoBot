package com.mousanony.telegram.bot.cryptobot.services;

import com.mousanony.telegram.bot.cryptobot.dto.Coin;
import com.mousanony.telegram.bot.cryptobot.dto.ExtendedCoin;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
public class Response {
    private String error;
    private Coin coin;
    private BigDecimal priceCustom;
    private BigDecimal calculatedAmount;
    private String targetCoinSymbol;

    public BigDecimal getPriceCustom() {
        return priceCustom;
    }

    public String getTargetCoinSymbol() {
        return targetCoinSymbol;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void calculateAmount(BigDecimal count) {
//        if (priceCustom != null ? priceCustom.multiply(count != null ? count : BigDecimal.ONE) : coin.getPriceUsd())
        this.calculatedAmount = priceCustom.multiply(count != null ? count : BigDecimal.ONE);
    }

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
