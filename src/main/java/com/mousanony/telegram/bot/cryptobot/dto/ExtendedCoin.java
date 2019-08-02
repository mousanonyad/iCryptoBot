package com.mousanony.telegram.bot.cryptobot.dto;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
public class ExtendedCoin extends Coin {
    private BigDecimal priceCustom;
    private BigDecimal calculatedAmount;
    private String targetCoinSymbol;

    public ExtendedCoin(Coin coin, BigDecimal priceCustom, String targetCoinSymbol) {
        super(coin);
        this.priceCustom = priceCustom;
        this.targetCoinSymbol = targetCoinSymbol;
    }

    public BigDecimal getPriceCustom() {
        return priceCustom;
    }

    public String getTargetCoinSymbol() {
        return targetCoinSymbol;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public ExtendedCoin calculateAmount(BigDecimal count) {
        this.calculatedAmount = priceCustom.multiply(count != null ? count : BigDecimal.ONE);
        return this;
    }
}
