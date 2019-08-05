package com.mousanony.telegram.bot.cryptobot.dto;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
public class ExtendedCoin extends Coin {
    private BigDecimal priceCustom;
    private String customSymbol;

    public ExtendedCoin(Coin coin, BigDecimal priceCustom, String customSymbol) {
        super(coin);
        this.priceCustom = priceCustom;
        this.customSymbol = customSymbol;
    }

    @Override
    public String getCustomSymbol() {
        return customSymbol;
    }

    @Override
    public BigDecimal getPrice() {
        return priceCustom;
    }


}
