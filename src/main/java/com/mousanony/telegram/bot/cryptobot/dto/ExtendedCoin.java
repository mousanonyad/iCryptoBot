package com.mousanony.telegram.bot.cryptobot.dto;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
public class ExtendedCoin extends Coin {
    private BigDecimal priceCustom;
    private String targetCoin;

    public ExtendedCoin(Coin coin, BigDecimal priceCustom, String targetCoin) {
        super(coin);
        this.priceCustom = priceCustom;
        this.targetCoin = targetCoin;
    }

    @Override
    public String getTargetCoin() {
        return targetCoin;
    }

    @Override
    public BigDecimal getPrice() {
        return priceCustom;
    }


}
